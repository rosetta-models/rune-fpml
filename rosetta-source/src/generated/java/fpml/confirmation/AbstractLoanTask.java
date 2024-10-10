package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.AbstractLoanTask;
import fpml.confirmation.AbstractLoanTask.AbstractLoanTaskBuilder;
import fpml.confirmation.AbstractLoanTask.AbstractLoanTaskBuilderImpl;
import fpml.confirmation.AbstractLoanTask.AbstractLoanTaskImpl;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.meta.AbstractLoanTaskMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An underlying abstract structure that defines the responsible party for tasks that must be completed.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanTask", builder=AbstractLoanTask.AbstractLoanTaskBuilderImpl.class, version="${project.version}")
public interface AbstractLoanTask extends RosettaModelObject {

	AbstractLoanTaskMeta metaData = new AbstractLoanTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The unique id of the settlement task.
	 */
	TaskIdentifier getTaskIdentifier();
	/**
	 * An identifier used to identify a group of related tasks.
	 */
	TaskIdentifier getParentTaskIdentifier();
	/**
	 * A unique identifier associated with a previous ‘inaccurate task.’ Population of this identifier represents that this task is a ‘corrective measure’ to a previous task, rather than being a stand-alone task.
	 */
	TaskIdentifier getCorrectedTaskIdentifier();
	/**
	 * A reference to the party responsible for the completion of the settlement task.
	 */
	PartyReference getResponsibleParty();
	/**
	 * Dates relevant to the settlement task.
	 */
	LoanTradingSettlementTaskDates getDates();
	/**
	 * An enum to define the status of the settlement task.
	 */
	LoanTradingSettlementTaskStatusEnum getStatus();
	/**
	 * A freetext field which allows the sender to add further details around the task.
	 */
	String getComment();

	/*********************** Build Methods  ***********************/
	AbstractLoanTask build();
	
	AbstractLoanTask.AbstractLoanTaskBuilder toBuilder();
	
	static AbstractLoanTask.AbstractLoanTaskBuilder builder() {
		return new AbstractLoanTask.AbstractLoanTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTask> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTask> getType() {
		return AbstractLoanTask.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.class, getTaskIdentifier());
		processRosetta(path.newSubPath("parentTaskIdentifier"), processor, TaskIdentifier.class, getParentTaskIdentifier());
		processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.class, getCorrectedTaskIdentifier());
		processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.class, getResponsibleParty());
		processRosetta(path.newSubPath("dates"), processor, LoanTradingSettlementTaskDates.class, getDates());
		processor.processBasic(path.newSubPath("status"), LoanTradingSettlementTaskStatusEnum.class, getStatus(), this);
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTaskBuilder extends AbstractLoanTask, RosettaModelObjectBuilder {
		TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateParentTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getParentTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getOrCreateCorrectedTaskIdentifier();
		TaskIdentifier.TaskIdentifierBuilder getCorrectedTaskIdentifier();
		PartyReference.PartyReferenceBuilder getOrCreateResponsibleParty();
		PartyReference.PartyReferenceBuilder getResponsibleParty();
		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder getOrCreateDates();
		LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder getDates();
		AbstractLoanTask.AbstractLoanTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);
		AbstractLoanTask.AbstractLoanTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier);
		AbstractLoanTask.AbstractLoanTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		AbstractLoanTask.AbstractLoanTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		AbstractLoanTask.AbstractLoanTaskBuilder setDates(LoanTradingSettlementTaskDates dates);
		AbstractLoanTask.AbstractLoanTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status);
		AbstractLoanTask.AbstractLoanTaskBuilder setComment(String comment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("parentTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getParentTaskIdentifier());
			processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getCorrectedTaskIdentifier());
			processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getResponsibleParty());
			processRosetta(path.newSubPath("dates"), processor, LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder.class, getDates());
			processor.processBasic(path.newSubPath("status"), LoanTradingSettlementTaskStatusEnum.class, getStatus(), this);
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		}
		

		AbstractLoanTask.AbstractLoanTaskBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTask  ***********************/
	class AbstractLoanTaskImpl implements AbstractLoanTask {
		private final TaskIdentifier taskIdentifier;
		private final TaskIdentifier parentTaskIdentifier;
		private final TaskIdentifier correctedTaskIdentifier;
		private final PartyReference responsibleParty;
		private final LoanTradingSettlementTaskDates dates;
		private final LoanTradingSettlementTaskStatusEnum status;
		private final String comment;
		
		protected AbstractLoanTaskImpl(AbstractLoanTask.AbstractLoanTaskBuilder builder) {
			this.taskIdentifier = ofNullable(builder.getTaskIdentifier()).map(f->f.build()).orElse(null);
			this.parentTaskIdentifier = ofNullable(builder.getParentTaskIdentifier()).map(f->f.build()).orElse(null);
			this.correctedTaskIdentifier = ofNullable(builder.getCorrectedTaskIdentifier()).map(f->f.build()).orElse(null);
			this.responsibleParty = ofNullable(builder.getResponsibleParty()).map(f->f.build()).orElse(null);
			this.dates = ofNullable(builder.getDates()).map(f->f.build()).orElse(null);
			this.status = builder.getStatus();
			this.comment = builder.getComment();
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public TaskIdentifier getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		public TaskIdentifier getParentTaskIdentifier() {
			return parentTaskIdentifier;
		}
		
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		public TaskIdentifier getCorrectedTaskIdentifier() {
			return correctedTaskIdentifier;
		}
		
		@Override
		@RosettaAttribute("responsibleParty")
		public PartyReference getResponsibleParty() {
			return responsibleParty;
		}
		
		@Override
		@RosettaAttribute("dates")
		public LoanTradingSettlementTaskDates getDates() {
			return dates;
		}
		
		@Override
		@RosettaAttribute("status")
		public LoanTradingSettlementTaskStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		public AbstractLoanTask build() {
			return this;
		}
		
		@Override
		public AbstractLoanTask.AbstractLoanTaskBuilder toBuilder() {
			AbstractLoanTask.AbstractLoanTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTask.AbstractLoanTaskBuilder builder) {
			ofNullable(getTaskIdentifier()).ifPresent(builder::setTaskIdentifier);
			ofNullable(getParentTaskIdentifier()).ifPresent(builder::setParentTaskIdentifier);
			ofNullable(getCorrectedTaskIdentifier()).ifPresent(builder::setCorrectedTaskIdentifier);
			ofNullable(getResponsibleParty()).ifPresent(builder::setResponsibleParty);
			ofNullable(getDates()).ifPresent(builder::setDates);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getComment()).ifPresent(builder::setComment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanTask _that = getType().cast(o);
		
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(parentTaskIdentifier, _that.getParentTaskIdentifier())) return false;
			if (!Objects.equals(correctedTaskIdentifier, _that.getCorrectedTaskIdentifier())) return false;
			if (!Objects.equals(responsibleParty, _that.getResponsibleParty())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentTaskIdentifier != null ? parentTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedTaskIdentifier != null ? correctedTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (responsibleParty != null ? responsibleParty.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTask {" +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"parentTaskIdentifier=" + this.parentTaskIdentifier + ", " +
				"correctedTaskIdentifier=" + this.correctedTaskIdentifier + ", " +
				"responsibleParty=" + this.responsibleParty + ", " +
				"dates=" + this.dates + ", " +
				"status=" + this.status + ", " +
				"comment=" + this.comment +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractLoanTask  ***********************/
	class AbstractLoanTaskBuilderImpl implements AbstractLoanTask.AbstractLoanTaskBuilder {
	
		protected TaskIdentifier.TaskIdentifierBuilder taskIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder parentTaskIdentifier;
		protected TaskIdentifier.TaskIdentifierBuilder correctedTaskIdentifier;
		protected PartyReference.PartyReferenceBuilder responsibleParty;
		protected LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder dates;
		protected LoanTradingSettlementTaskStatusEnum status;
		protected String comment;
	
		public AbstractLoanTaskBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("taskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getTaskIdentifier() {
			return taskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (taskIdentifier!=null) {
				result = taskIdentifier;
			}
			else {
				result = taskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getParentTaskIdentifier() {
			return parentTaskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateParentTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (parentTaskIdentifier!=null) {
				result = parentTaskIdentifier;
			}
			else {
				result = parentTaskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		public TaskIdentifier.TaskIdentifierBuilder getCorrectedTaskIdentifier() {
			return correctedTaskIdentifier;
		}
		
		@Override
		public TaskIdentifier.TaskIdentifierBuilder getOrCreateCorrectedTaskIdentifier() {
			TaskIdentifier.TaskIdentifierBuilder result;
			if (correctedTaskIdentifier!=null) {
				result = correctedTaskIdentifier;
			}
			else {
				result = correctedTaskIdentifier = TaskIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("responsibleParty")
		public PartyReference.PartyReferenceBuilder getResponsibleParty() {
			return responsibleParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateResponsibleParty() {
			PartyReference.PartyReferenceBuilder result;
			if (responsibleParty!=null) {
				result = responsibleParty;
			}
			else {
				result = responsibleParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dates")
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder getDates() {
			return dates;
		}
		
		@Override
		public LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder getOrCreateDates() {
			LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder result;
			if (dates!=null) {
				result = dates;
			}
			else {
				result = dates = LoanTradingSettlementTaskDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("status")
		public LoanTradingSettlementTaskStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("comment")
		public String getComment() {
			return comment;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public AbstractLoanTask.AbstractLoanTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier) {
			this.taskIdentifier = taskIdentifier==null?null:taskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		public AbstractLoanTask.AbstractLoanTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier) {
			this.parentTaskIdentifier = parentTaskIdentifier==null?null:parentTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		public AbstractLoanTask.AbstractLoanTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier) {
			this.correctedTaskIdentifier = correctedTaskIdentifier==null?null:correctedTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("responsibleParty")
		public AbstractLoanTask.AbstractLoanTaskBuilder setResponsibleParty(PartyReference responsibleParty) {
			this.responsibleParty = responsibleParty==null?null:responsibleParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dates")
		public AbstractLoanTask.AbstractLoanTaskBuilder setDates(LoanTradingSettlementTaskDates dates) {
			this.dates = dates==null?null:dates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public AbstractLoanTask.AbstractLoanTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status) {
			this.status = status==null?null:status;
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanTask.AbstractLoanTaskBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		
		@Override
		public AbstractLoanTask build() {
			return new AbstractLoanTask.AbstractLoanTaskImpl(this);
		}
		
		@Override
		public AbstractLoanTask.AbstractLoanTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTask.AbstractLoanTaskBuilder prune() {
			if (taskIdentifier!=null && !taskIdentifier.prune().hasData()) taskIdentifier = null;
			if (parentTaskIdentifier!=null && !parentTaskIdentifier.prune().hasData()) parentTaskIdentifier = null;
			if (correctedTaskIdentifier!=null && !correctedTaskIdentifier.prune().hasData()) correctedTaskIdentifier = null;
			if (responsibleParty!=null && !responsibleParty.prune().hasData()) responsibleParty = null;
			if (dates!=null && !dates.prune().hasData()) dates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTaskIdentifier()!=null && getTaskIdentifier().hasData()) return true;
			if (getParentTaskIdentifier()!=null && getParentTaskIdentifier().hasData()) return true;
			if (getCorrectedTaskIdentifier()!=null && getCorrectedTaskIdentifier().hasData()) return true;
			if (getResponsibleParty()!=null && getResponsibleParty().hasData()) return true;
			if (getDates()!=null && getDates().hasData()) return true;
			if (getStatus()!=null) return true;
			if (getComment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTask.AbstractLoanTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractLoanTask.AbstractLoanTaskBuilder o = (AbstractLoanTask.AbstractLoanTaskBuilder) other;
			
			merger.mergeRosetta(getTaskIdentifier(), o.getTaskIdentifier(), this::setTaskIdentifier);
			merger.mergeRosetta(getParentTaskIdentifier(), o.getParentTaskIdentifier(), this::setParentTaskIdentifier);
			merger.mergeRosetta(getCorrectedTaskIdentifier(), o.getCorrectedTaskIdentifier(), this::setCorrectedTaskIdentifier);
			merger.mergeRosetta(getResponsibleParty(), o.getResponsibleParty(), this::setResponsibleParty);
			merger.mergeRosetta(getDates(), o.getDates(), this::setDates);
			
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeBasic(getComment(), o.getComment(), this::setComment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractLoanTask _that = getType().cast(o);
		
			if (!Objects.equals(taskIdentifier, _that.getTaskIdentifier())) return false;
			if (!Objects.equals(parentTaskIdentifier, _that.getParentTaskIdentifier())) return false;
			if (!Objects.equals(correctedTaskIdentifier, _that.getCorrectedTaskIdentifier())) return false;
			if (!Objects.equals(responsibleParty, _that.getResponsibleParty())) return false;
			if (!Objects.equals(dates, _that.getDates())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(comment, _that.getComment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (taskIdentifier != null ? taskIdentifier.hashCode() : 0);
			_result = 31 * _result + (parentTaskIdentifier != null ? parentTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (correctedTaskIdentifier != null ? correctedTaskIdentifier.hashCode() : 0);
			_result = 31 * _result + (responsibleParty != null ? responsibleParty.hashCode() : 0);
			_result = 31 * _result + (dates != null ? dates.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment != null ? comment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTaskBuilder {" +
				"taskIdentifier=" + this.taskIdentifier + ", " +
				"parentTaskIdentifier=" + this.parentTaskIdentifier + ", " +
				"correctedTaskIdentifier=" + this.correctedTaskIdentifier + ", " +
				"responsibleParty=" + this.responsibleParty + ", " +
				"dates=" + this.dates + ", " +
				"status=" + this.status + ", " +
				"comment=" + this.comment +
			'}';
		}
	}
}
