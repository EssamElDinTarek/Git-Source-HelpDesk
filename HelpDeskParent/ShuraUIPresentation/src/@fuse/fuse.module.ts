import { ModuleWithProviders, NgModule, Optional, SkipSelf } from '@angular/core';

import { FUSE_CONFIG, FuseConfigService } from './services/config.service';
import { FuseCopierService } from './services/copier.service';
import { FuseMatchMediaService } from './services/match-media.service';
import { FuseMatSidenavHelperService } from './directives/fuse-mat-sidenav/fuse-mat-sidenav.service';
import { FuseNavigationService } from './components/navigation/navigation.service';
import { FuseSidebarService } from './components/sidebar/sidebar.service';
import { FuseSplashScreenService } from './services/splash-screen.service';
import { FuseTranslationLoaderService } from './services/translation-loader.service';

@NgModule({
    entryComponents: [],
    providers      : [
        FuseConfigService,
        FuseCopierService,
        FuseMatchMediaService,
        FuseMatSidenavHelperService,
        FuseNavigationService,
        FuseSidebarService,
        FuseSplashScreenService,
        FuseTranslationLoaderService
    ]
})
export class FuseModule
{
    constructor(@Optional() @SkipSelf() parentModule: FuseModule)
    {
        if ( parentModule )
        {
            throw new Error('FuseModule is already loaded. Import it in the AppModule only!');
        }
    }

    static forRoot(config): ModuleWithProviders
    {
        return {
            ngModule : FuseModule,
            providers: [
                {
                    provide : FUSE_CONFIG,
                    useValue: config
                }
            ]
        };
    }
}
