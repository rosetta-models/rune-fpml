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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.AbstractLoanContractEvent;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilder;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl;
import fpml.confirmation.AbstractLoanContractEvent.AbstractLoanContractEventImpl;
import fpml.confirmation.AbstractLoanServicingEvent;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.AbstractLoanContractEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all loan contract-level business events.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLoanContractEvent", builder=AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl.class, version="${project.version}")
public interface AbstractLoanContractEvent extends AbstractLoanServicingEvent {

	AbstractLoanContractEventMeta metaData = new AbstractLoanContractEventMeta();

	/*********************** Getter Methods  ***********************/
	LoanContractReference getLoanContractReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanContractEvent build();
	
	AbstractLoanContractEvent.AbstractLoanContractEventBuilder toBuilder();
	
	static AbstractLoanContractEvent.AbstractLoanContractEventBuilder builder() {
		return new AbstractLoanContractEvent.AbstractLoanContractEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanContractEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanContractEvent> getType() {
		return AbstractLoanContractEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanContractEventBuilder extends AbstractLoanContractEvent, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference();
		LoanContractReference.LoanContractReferenceBuilder getLoanContractReference();
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setComment(String comment);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setEffectiveDate(Date effectiveDate);
		AbstractLoanContractEvent.AbstractLoanContractEventBuilder setLoanContractReference(LoanContractReference loanContractReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		AbstractLoanContractEvent.AbstractLoanContractEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanContractEvent  ***********************/
	class AbstractLoanContractEventImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventImpl implements AbstractLoanContractEvent {
		private final LoanContractReference loanContractReference;
		
		protected AbstractLoanContractEventImpl(AbstractLoanContractEvent.AbstractLoanContractEventBuilder builder) {
			super(builder);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public AbstractLoanContractEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder toBuilder() {
			AbstractLoanContractEvent.AbstractLoanContractEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanContractEvent.AbstractLoanContractEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanContractEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanContractEvent {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanContractEvent  ***********************/
	class AbstractLoanContractEventBuilderImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl  implements AbstractLoanContractEvent.AbstractLoanContractEventBuilder {
	
		protected LoanContractReference.LoanContractReferenceBuilder loanContractReference;
	
		public AbstractLoanContractEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanContractReference")
		public LoanContractReference.LoanContractReferenceBuilder getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (loanContractReference!=null) {
				result = loanContractReference;
			}
			else {
				result = loanContractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("loanContractReference")
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder setLoanContractReference(LoanContractReference loanContractReference) {
			this.loanContractReference = loanContractReference==null?null:loanContractReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanContractEvent build() {
			return new AbstractLoanContractEvent.AbstractLoanContractEventImpl(this);
		}
		
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder prune() {
			super.prune();
			if (loanContractReference!=null && !loanContractReference.prune().hasData()) loanContractReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanContractEvent.AbstractLoanContractEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanContractEvent.AbstractLoanContractEventBuilder o = (AbstractLoanContractEvent.AbstractLoanContractEventBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::setLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanContractEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanContractEventBuilder {" +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}
}
