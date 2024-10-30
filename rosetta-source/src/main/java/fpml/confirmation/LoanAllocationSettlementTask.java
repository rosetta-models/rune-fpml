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
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationSettlementTask;
import fpml.confirmation.LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder;
import fpml.confirmation.LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl;
import fpml.confirmation.LoanAllocationSettlementTask.LoanAllocationSettlementTaskImpl;
import fpml.confirmation.LoanAllocationSettlementTaskType;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.meta.LoanAllocationSettlementTaskMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that details tasks and their statuses, the completion of which are prerequisites to the settlement of a trade or allocation.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LoanAllocationSettlementTask", builder=LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LoanAllocationSettlementTask extends AbstractLoanTask {

	LoanAllocationSettlementTaskMeta metaData = new LoanAllocationSettlementTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a unique allocation id used to identify the allocation record.
	 */
	LoanAllocationReference getAllocationReference();
	/**
	 * The type of the settlement task.
	 */
	LoanAllocationSettlementTaskType get_type();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementTask build();
	
	LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder();
	
	static LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder() {
		return new LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementTask> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationSettlementTask> getType() {
		return LoanAllocationSettlementTask.class;
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
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("_type"), processor, LoanAllocationSettlementTaskType.class, get_type());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementTaskBuilder extends LoanAllocationSettlementTask, AbstractLoanTask.AbstractLoanTaskBuilder {
		LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference();
		LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference();
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder getOrCreate_type();
		LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder get_type();
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setDates(LoanTradingSettlementTaskDates dates);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setComment(String comment);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder set_type(LoanAllocationSettlementTaskType _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("parentTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getParentTaskIdentifier());
			processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getCorrectedTaskIdentifier());
			processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getResponsibleParty());
			processRosetta(path.newSubPath("dates"), processor, LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder.class, getDates());
			processor.processBasic(path.newSubPath("status"), LoanTradingSettlementTaskStatusEnum.class, getStatus(), this);
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("_type"), processor, LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder.class, get_type());
		}
		

		LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementTask  ***********************/
	class LoanAllocationSettlementTaskImpl extends AbstractLoanTask.AbstractLoanTaskImpl implements LoanAllocationSettlementTask {
		private final LoanAllocationReference allocationReference;
		private final LoanAllocationSettlementTaskType _type;
		
		protected LoanAllocationSettlementTaskImpl(LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder) {
			super(builder);
			this.allocationReference = ofNullable(builder.getAllocationReference()).map(f->f.build()).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanAllocationSettlementTaskType get_type() {
			return _type;
		}
		
		@Override
		public LoanAllocationSettlementTask build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder() {
			LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAllocationReference()).ifPresent(builder::setAllocationReference);
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTask {" +
				"allocationReference=" + this.allocationReference + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementTask  ***********************/
	class LoanAllocationSettlementTaskBuilderImpl extends AbstractLoanTask.AbstractLoanTaskBuilderImpl  implements LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder {
	
		protected LoanAllocationReference.LoanAllocationReferenceBuilder allocationReference;
		protected LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder _type;
	
		public LoanAllocationSettlementTaskBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationReference.LoanAllocationReferenceBuilder getAllocationReference() {
			return allocationReference;
		}
		
		@Override
		public LoanAllocationReference.LoanAllocationReferenceBuilder getOrCreateAllocationReference() {
			LoanAllocationReference.LoanAllocationReferenceBuilder result;
			if (allocationReference!=null) {
				result = allocationReference;
			}
			else {
				result = allocationReference = LoanAllocationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder getOrCreate_type() {
			LoanAllocationSettlementTaskType.LoanAllocationSettlementTaskTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = LoanAllocationSettlementTaskType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier) {
			this.taskIdentifier = taskIdentifier==null?null:taskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier) {
			this.parentTaskIdentifier = parentTaskIdentifier==null?null:parentTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier) {
			this.correctedTaskIdentifier = correctedTaskIdentifier==null?null:correctedTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("responsibleParty")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty) {
			this.responsibleParty = responsibleParty==null?null:responsibleParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dates")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setDates(LoanTradingSettlementTaskDates dates) {
			this.dates = dates==null?null:dates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status) {
			this.status = status==null?null:status;
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("allocationReference")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder setAllocationReference(LoanAllocationReference allocationReference) {
			this.allocationReference = allocationReference==null?null:allocationReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder set_type(LoanAllocationSettlementTaskType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationSettlementTask build() {
			return new LoanAllocationSettlementTask.LoanAllocationSettlementTaskImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder prune() {
			super.prune();
			if (allocationReference!=null && !allocationReference.prune().hasData()) allocationReference = null;
			if (_type!=null && !_type.prune().hasData()) _type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAllocationReference()!=null && getAllocationReference().hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder o = (LoanAllocationSettlementTask.LoanAllocationSettlementTaskBuilder) other;
			
			merger.mergeRosetta(getAllocationReference(), o.getAllocationReference(), this::setAllocationReference);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(allocationReference, _that.getAllocationReference())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (allocationReference != null ? allocationReference.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementTaskBuilder {" +
				"allocationReference=" + this.allocationReference + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}
}
