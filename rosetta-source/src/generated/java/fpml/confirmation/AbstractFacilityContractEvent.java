package fpml.confirmation;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.confirmation.AbstractFacilityContractEvent;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl;
import fpml.confirmation.AbstractFacilityContractEvent.AbstractFacilityContractEventImpl;
import fpml.confirmation.AbstractLoanServicingEvent;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanContractReference;
import fpml.confirmation.meta.AbstractFacilityContractEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all facility and/or contract-level business events.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractFacilityContractEvent", builder=AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl.class, version="${project.version}")
public interface AbstractFacilityContractEvent extends AbstractLoanServicingEvent {

	AbstractFacilityContractEventMeta metaData = new AbstractFacilityContractEventMeta();

	/*********************** Getter Methods  ***********************/
	FacilityReference getFacilityReference();
	/**
	 * A loan contract summary structure.
	 */
	List<? extends LoanContractReference> getLoanContractReference();

	/*********************** Build Methods  ***********************/
	AbstractFacilityContractEvent build();
	
	AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder();
	
	static AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder() {
		return new AbstractFacilityContractEvent.AbstractFacilityContractEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractFacilityContractEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractFacilityContractEvent> getType() {
		return AbstractFacilityContractEvent.class;
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
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractFacilityContractEventBuilder extends AbstractFacilityContractEvent, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
		FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference();
		FacilityReference.FacilityReferenceBuilder getFacilityReference();
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int _index);
		List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference();
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setComment(String comment);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEffectiveDate(Date effectiveDate);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setFacilityReference(FacilityReference facilityReference);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference0);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference1, int _idx);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference2);
		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractFacilityContractEvent  ***********************/
	class AbstractFacilityContractEventImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventImpl implements AbstractFacilityContractEvent {
		private final FacilityReference facilityReference;
		private final List<? extends LoanContractReference> loanContractReference;
		
		protected AbstractFacilityContractEventImpl(AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder) {
			super(builder);
			this.facilityReference = ofNullable(builder.getFacilityReference()).map(f->f.build()).orElse(null);
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public List<? extends LoanContractReference> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public AbstractFacilityContractEvent build() {
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder() {
			AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityReference()).ifPresent(builder::setFacilityReference);
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityContractEvent _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityContractEvent {" +
				"facilityReference=" + this.facilityReference + ", " +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractFacilityContractEvent  ***********************/
	class AbstractFacilityContractEventBuilderImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl  implements AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder {
	
		protected FacilityReference.FacilityReferenceBuilder facilityReference;
		protected List<LoanContractReference.LoanContractReferenceBuilder> loanContractReference = new ArrayList<>();
	
		public AbstractFacilityContractEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("facilityReference")
		public FacilityReference.FacilityReferenceBuilder getFacilityReference() {
			return facilityReference;
		}
		
		@Override
		public FacilityReference.FacilityReferenceBuilder getOrCreateFacilityReference() {
			FacilityReference.FacilityReferenceBuilder result;
			if (facilityReference!=null) {
				result = facilityReference;
			}
			else {
				result = facilityReference = FacilityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		public List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference() {
			return loanContractReference;
		}
		
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int _index) {
		
			if (loanContractReference==null) {
				this.loanContractReference = new ArrayList<>();
			}
			LoanContractReference.LoanContractReferenceBuilder result;
			return getIndex(loanContractReference, _index, () -> {
						LoanContractReference.LoanContractReferenceBuilder newLoanContractReference = LoanContractReference.builder();
						return newLoanContractReference;
					});
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference) {
			if (loanContractReference!=null) this.loanContractReference.add(loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(LoanContractReference loanContractReference, int _idx) {
			getIndex(this.loanContractReference, _idx, () -> loanContractReference.toBuilder());
			return this;
		}
		@Override 
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("loanContractReference")
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null)  {
				this.loanContractReference = new ArrayList<>();
			}
			else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public AbstractFacilityContractEvent build() {
			return new AbstractFacilityContractEvent.AbstractFacilityContractEventImpl(this);
		}
		
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder prune() {
			super.prune();
			if (facilityReference!=null && !facilityReference.prune().hasData()) facilityReference = null;
			loanContractReference = loanContractReference.stream().filter(b->b!=null).<LoanContractReference.LoanContractReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityReference()!=null && getFacilityReference().hasData()) return true;
			if (getLoanContractReference()!=null && getLoanContractReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder o = (AbstractFacilityContractEvent.AbstractFacilityContractEventBuilder) other;
			
			merger.mergeRosetta(getFacilityReference(), o.getFacilityReference(), this::setFacilityReference);
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::getOrCreateLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractFacilityContractEvent _that = getType().cast(o);
		
			if (!Objects.equals(facilityReference, _that.getFacilityReference())) return false;
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityReference != null ? facilityReference.hashCode() : 0);
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractFacilityContractEventBuilder {" +
				"facilityReference=" + this.facilityReference + ", " +
				"loanContractReference=" + this.loanContractReference +
			'}' + " " + super.toString();
		}
	}
}
