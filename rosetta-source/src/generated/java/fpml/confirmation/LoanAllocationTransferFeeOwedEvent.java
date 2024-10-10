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
import fpml.confirmation.AbstractLoanAllocationEvent;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl;
import fpml.confirmation.AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanAllocationReference;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilderImpl;
import fpml.confirmation.LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventImpl;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import fpml.confirmation.meta.LoanAllocationTransferFeeOwedEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines details related to the admin agent&#39;s determination of transfer fee(s) owed on an allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationTransferFeeOwedEvent", builder=LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilderImpl.class, version="${project.version}")
public interface LoanAllocationTransferFeeOwedEvent extends AbstractLoanAllocationEvent {

	LoanAllocationTransferFeeOwedEventMeta metaData = new LoanAllocationTransferFeeOwedEventMeta();

	/*********************** Getter Methods  ***********************/
	LoanTradingTransferFeeDeterminationModel getLoanTradingTransferFeeDeterminationModel();

	/*********************** Build Methods  ***********************/
	LoanAllocationTransferFeeOwedEvent build();
	
	LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder toBuilder();
	
	static LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder builder() {
		return new LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationTransferFeeOwedEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationTransferFeeOwedEvent> getType() {
		return LoanAllocationTransferFeeOwedEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("loanTradingTransferFeeDeterminationModel"), processor, LoanTradingTransferFeeDeterminationModel.class, getLoanTradingTransferFeeDeterminationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationTransferFeeOwedEventBuilder extends LoanAllocationTransferFeeOwedEvent, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getOrCreateLoanTradingTransferFeeDeterminationModel();
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getLoanTradingTransferFeeDeterminationModel();
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setComment(String comment);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(LoanAllocationReference allocationReference0);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(LoanAllocationReference allocationReference1, int _idx);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReference2);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReference3);
		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setLoanTradingTransferFeeDeterminationModel(LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("loanTradingTransferFeeDeterminationModel"), processor, LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder.class, getLoanTradingTransferFeeDeterminationModel());
		}
		

		LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationTransferFeeOwedEvent  ***********************/
	class LoanAllocationTransferFeeOwedEventImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationTransferFeeOwedEvent {
		private final LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel;
		
		protected LoanAllocationTransferFeeOwedEventImpl(LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder builder) {
			super(builder);
			this.loanTradingTransferFeeDeterminationModel = ofNullable(builder.getLoanTradingTransferFeeDeterminationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanTradingTransferFeeDeterminationModel getLoanTradingTransferFeeDeterminationModel() {
			return loanTradingTransferFeeDeterminationModel;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent build() {
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder toBuilder() {
			LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradingTransferFeeDeterminationModel()).ifPresent(builder::setLoanTradingTransferFeeDeterminationModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeOwedEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingTransferFeeDeterminationModel, _that.getLoanTradingTransferFeeDeterminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradingTransferFeeDeterminationModel != null ? loanTradingTransferFeeDeterminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwedEvent {" +
				"loanTradingTransferFeeDeterminationModel=" + this.loanTradingTransferFeeDeterminationModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationTransferFeeOwedEvent  ***********************/
	class LoanAllocationTransferFeeOwedEventBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl  implements LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder {
	
		protected LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder loanTradingTransferFeeDeterminationModel;
	
		public LoanAllocationTransferFeeOwedEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getLoanTradingTransferFeeDeterminationModel() {
			return loanTradingTransferFeeDeterminationModel;
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getOrCreateLoanTradingTransferFeeDeterminationModel() {
			LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder result;
			if (loanTradingTransferFeeDeterminationModel!=null) {
				result = loanTradingTransferFeeDeterminationModel;
			}
			else {
				result = loanTradingTransferFeeDeterminationModel = LoanTradingTransferFeeDeterminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(LoanAllocationReference allocationReference) {
			if (allocationReference!=null) this.allocationReference.add(allocationReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(LoanAllocationReference allocationReference, int _idx) {
			getIndex(this.allocationReference, _idx, () -> allocationReference.toBuilder());
			return this;
		}
		@Override 
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder addAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences != null) {
				for (LoanAllocationReference toAdd : allocationReferences) {
					this.allocationReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("allocationReference")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setAllocationReference(List<? extends LoanAllocationReference> allocationReferences) {
			if (allocationReferences == null)  {
				this.allocationReference = new ArrayList<>();
			}
			else {
				this.allocationReference = allocationReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder setLoanTradingTransferFeeDeterminationModel(LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel) {
			this.loanTradingTransferFeeDeterminationModel = loanTradingTransferFeeDeterminationModel==null?null:loanTradingTransferFeeDeterminationModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent build() {
			return new LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventImpl(this);
		}
		
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder prune() {
			super.prune();
			if (loanTradingTransferFeeDeterminationModel!=null && !loanTradingTransferFeeDeterminationModel.prune().hasData()) loanTradingTransferFeeDeterminationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradingTransferFeeDeterminationModel()!=null && getLoanTradingTransferFeeDeterminationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder o = (LoanAllocationTransferFeeOwedEvent.LoanAllocationTransferFeeOwedEventBuilder) other;
			
			merger.mergeRosetta(getLoanTradingTransferFeeDeterminationModel(), o.getLoanTradingTransferFeeDeterminationModel(), this::setLoanTradingTransferFeeDeterminationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationTransferFeeOwedEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingTransferFeeDeterminationModel, _that.getLoanTradingTransferFeeDeterminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradingTransferFeeDeterminationModel != null ? loanTradingTransferFeeDeterminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationTransferFeeOwedEventBuilder {" +
				"loanTradingTransferFeeDeterminationModel=" + this.loanTradingTransferFeeDeterminationModel +
			'}' + " " + super.toString();
		}
	}
}
