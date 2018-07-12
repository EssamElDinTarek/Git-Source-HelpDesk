import { WorkflowStep } from './workflowStep';
export class Workflow {
    flowId: Number;
	ticketType: string;
	workflowSteps: WorkflowStep[];
}