import { LookupManagementModule } from './lookup-management.module';

describe('LookupManagementModule', () => {
  let lookupManagementModule: LookupManagementModule;

  beforeEach(() => {
    lookupManagementModule = new LookupManagementModule();
  });

  it('should create an instance', () => {
    expect(lookupManagementModule).toBeTruthy();
  });
});
