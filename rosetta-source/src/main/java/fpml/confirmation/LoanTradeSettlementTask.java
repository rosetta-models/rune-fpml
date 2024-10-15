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
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeSettlementTask;
import fpml.confirmation.LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder;
import fpml.confirmation.LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl;
import fpml.confirmation.LoanTradeSettlementTask.LoanTradeSettlementTaskImpl;
import fpml.confirmation.LoanTradeSettlementTaskType;
import fpml.confirmation.LoanTradingSettlementTaskDates;
import fpml.confirmation.LoanTradingSettlementTaskStatusEnum;
import fpml.confirmation.PartyReference;
import fpml.confirmation.TaskIdentifier;
import fpml.confirmation.meta.LoanTradeSettlementTaskMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that details tasks and their statuses, the completion of which are prerequisites to the settlement of a trade or allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeSettlementTask", builder=LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl.class, version="${project.version}")
public interface LoanTradeSettlementTask extends AbstractLoanTask {

	LoanTradeSettlementTaskMeta metaData = new LoanTradeSettlementTaskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the master trade.
	 */
	LoanTradeReference getLoanTradeReference();
	/**
	 * The type of the settlement task.
	 */
	LoanTradeSettlementTaskType get_type();

	/*********************** Build Methods  ***********************/
	LoanTradeSettlementTask build();
	
	LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder();
	
	static LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder() {
		return new LoanTradeSettlementTask.LoanTradeSettlementTaskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeSettlementTask> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeSettlementTask> getType() {
		return LoanTradeSettlementTask.class;
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
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("_type"), processor, LoanTradeSettlementTaskType.class, get_type());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeSettlementTaskBuilder extends LoanTradeSettlementTask, AbstractLoanTask.AbstractLoanTaskBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder getOrCreate_type();
		LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder get_type();
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setDates(LoanTradingSettlementTaskDates dates);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setComment(String comment);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder set_type(LoanTradeSettlementTaskType _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("taskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getTaskIdentifier());
			processRosetta(path.newSubPath("parentTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getParentTaskIdentifier());
			processRosetta(path.newSubPath("correctedTaskIdentifier"), processor, TaskIdentifier.TaskIdentifierBuilder.class, getCorrectedTaskIdentifier());
			processRosetta(path.newSubPath("responsibleParty"), processor, PartyReference.PartyReferenceBuilder.class, getResponsibleParty());
			processRosetta(path.newSubPath("dates"), processor, LoanTradingSettlementTaskDates.LoanTradingSettlementTaskDatesBuilder.class, getDates());
			processor.processBasic(path.newSubPath("status"), LoanTradingSettlementTaskStatusEnum.class, getStatus(), this);
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("_type"), processor, LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder.class, get_type());
		}
		

		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeSettlementTask  ***********************/
	class LoanTradeSettlementTaskImpl extends AbstractLoanTask.AbstractLoanTaskImpl implements LoanTradeSettlementTask {
		private final LoanTradeReference loanTradeReference;
		private final LoanTradeSettlementTaskType _type;
		
		protected LoanTradeSettlementTaskImpl(LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradeSettlementTaskType get_type() {
			return _type;
		}
		
		@Override
		public LoanTradeSettlementTask build() {
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder() {
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTask {" +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeSettlementTask  ***********************/
	class LoanTradeSettlementTaskBuilderImpl extends AbstractLoanTask.AbstractLoanTaskBuilderImpl  implements LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
		protected LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder _type;
	
		public LoanTradeSettlementTaskBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder getOrCreate_type() {
			LoanTradeSettlementTaskType.LoanTradeSettlementTaskTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = LoanTradeSettlementTaskType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("taskIdentifier")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setTaskIdentifier(TaskIdentifier taskIdentifier) {
			this.taskIdentifier = taskIdentifier==null?null:taskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parentTaskIdentifier")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setParentTaskIdentifier(TaskIdentifier parentTaskIdentifier) {
			this.parentTaskIdentifier = parentTaskIdentifier==null?null:parentTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedTaskIdentifier")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setCorrectedTaskIdentifier(TaskIdentifier correctedTaskIdentifier) {
			this.correctedTaskIdentifier = correctedTaskIdentifier==null?null:correctedTaskIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("responsibleParty")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setResponsibleParty(PartyReference responsibleParty) {
			this.responsibleParty = responsibleParty==null?null:responsibleParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dates")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setDates(LoanTradingSettlementTaskDates dates) {
			this.dates = dates==null?null:dates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setStatus(LoanTradingSettlementTaskStatusEnum status) {
			this.status = status==null?null:status;
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder set_type(LoanTradeSettlementTaskType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeSettlementTask build() {
			return new LoanTradeSettlementTask.LoanTradeSettlementTaskImpl(this);
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			if (_type!=null && !_type.prune().hasData()) _type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder o = (LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeSettlementTask _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeSettlementTaskBuilder {" +
				"loanTradeReference=" + this.loanTradeReference + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}
}
