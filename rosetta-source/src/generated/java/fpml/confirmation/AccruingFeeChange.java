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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.AccruingFeeChange;
import fpml.confirmation.AccruingFeeChange.AccruingFeeChangeBuilder;
import fpml.confirmation.AccruingFeeChange.AccruingFeeChangeBuilderImpl;
import fpml.confirmation.AccruingFeeChange.AccruingFeeChangeImpl;
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AccruingFeeChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing a future change an accruing fee associated with a specific facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeeChange", builder=AccruingFeeChange.AccruingFeeChangeBuilderImpl.class, version="${project.version}")
public interface AccruingFeeChange extends AbstractFacilityEvent {

	AccruingFeeChangeMeta metaData = new AccruingFeeChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines new rate and the date on which the rate is no longer valid.
	 */
	AccruingFeeOption getAccruingFeeOption();

	/*********************** Build Methods  ***********************/
	AccruingFeeChange build();
	
	AccruingFeeChange.AccruingFeeChangeBuilder toBuilder();
	
	static AccruingFeeChange.AccruingFeeChangeBuilder builder() {
		return new AccruingFeeChange.AccruingFeeChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeChange> getType() {
		return AccruingFeeChange.class;
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
		processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.class, getAccruingFeeOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeChangeBuilder extends AccruingFeeChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption();
		AccruingFeeOption.AccruingFeeOptionBuilder getAccruingFeeOption();
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingFeeChange.AccruingFeeChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingFeeChange.AccruingFeeChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingFeeChange.AccruingFeeChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingFeeChange.AccruingFeeChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingFeeChange.AccruingFeeChangeBuilder setComment(String comment);
		AccruingFeeChange.AccruingFeeChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingFeeChange.AccruingFeeChangeBuilder setEffectiveDate(Date effectiveDate);
		AccruingFeeChange.AccruingFeeChangeBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingFeeChange.AccruingFeeChangeBuilder setAccruingFeeOption(AccruingFeeOption accruingFeeOption);

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
			processRosetta(path.newSubPath("accruingFeeOption"), processor, AccruingFeeOption.AccruingFeeOptionBuilder.class, getAccruingFeeOption());
		}
		

		AccruingFeeChange.AccruingFeeChangeBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeChange  ***********************/
	class AccruingFeeChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeeChange {
		private final AccruingFeeOption accruingFeeOption;
		
		protected AccruingFeeChangeImpl(AccruingFeeChange.AccruingFeeChangeBuilder builder) {
			super(builder);
			this.accruingFeeOption = ofNullable(builder.getAccruingFeeOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingFeeOption")
		public AccruingFeeOption getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		public AccruingFeeChange build() {
			return this;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder toBuilder() {
			AccruingFeeChange.AccruingFeeChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeChange.AccruingFeeChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingFeeOption()).ifPresent(builder::setAccruingFeeOption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChange {" +
				"accruingFeeOption=" + this.accruingFeeOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeChange  ***********************/
	class AccruingFeeChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingFeeChange.AccruingFeeChangeBuilder {
	
		protected AccruingFeeOption.AccruingFeeOptionBuilder accruingFeeOption;
	
		public AccruingFeeChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingFeeOption")
		public AccruingFeeOption.AccruingFeeOptionBuilder getAccruingFeeOption() {
			return accruingFeeOption;
		}
		
		@Override
		public AccruingFeeOption.AccruingFeeOptionBuilder getOrCreateAccruingFeeOption() {
			AccruingFeeOption.AccruingFeeOptionBuilder result;
			if (accruingFeeOption!=null) {
				result = accruingFeeOption;
			}
			else {
				result = accruingFeeOption = AccruingFeeOption.builder();
			}
			
			return result;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeeChange.AccruingFeeChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AccruingFeeChange.AccruingFeeChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingFeeChange.AccruingFeeChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingFeeChange.AccruingFeeChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingFeeChange.AccruingFeeChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingFeeChange.AccruingFeeChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingFeeChange.AccruingFeeChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingFeeChange.AccruingFeeChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingFeeChange.AccruingFeeChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingFeeOption")
		public AccruingFeeChange.AccruingFeeChangeBuilder setAccruingFeeOption(AccruingFeeOption accruingFeeOption) {
			this.accruingFeeOption = accruingFeeOption==null?null:accruingFeeOption.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeeChange build() {
			return new AccruingFeeChange.AccruingFeeChangeImpl(this);
		}
		
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder prune() {
			super.prune();
			if (accruingFeeOption!=null && !accruingFeeOption.prune().hasData()) accruingFeeOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingFeeOption()!=null && getAccruingFeeOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeChange.AccruingFeeChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeeChange.AccruingFeeChangeBuilder o = (AccruingFeeChange.AccruingFeeChangeBuilder) other;
			
			merger.mergeRosetta(getAccruingFeeOption(), o.getAccruingFeeOption(), this::setAccruingFeeOption);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingFeeOption, _that.getAccruingFeeOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingFeeOption != null ? accruingFeeOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeChangeBuilder {" +
				"accruingFeeOption=" + this.accruingFeeOption +
			'}' + " " + super.toString();
		}
	}
}
