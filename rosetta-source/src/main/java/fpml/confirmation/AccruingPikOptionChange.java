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
import fpml.confirmation.AccruingPikOption;
import fpml.confirmation.AccruingPikOptionChange;
import fpml.confirmation.AccruingPikOptionChange.AccruingPikOptionChangeBuilder;
import fpml.confirmation.AccruingPikOptionChange.AccruingPikOptionChangeBuilderImpl;
import fpml.confirmation.AccruingPikOptionChange.AccruingPikOptionChangeImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AccruingPikOptionChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in a PIK accrual option. In real terms - an example of this would be a margin rate change.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingPikOptionChange", builder=AccruingPikOptionChange.AccruingPikOptionChangeBuilderImpl.class, version="${project.version}")
public interface AccruingPikOptionChange extends AbstractFacilityEvent {

	AccruingPikOptionChangeMeta metaData = new AccruingPikOptionChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The latest version of the acccruing PIK option.
	 */
	AccruingPikOption getAccruingPikOption();

	/*********************** Build Methods  ***********************/
	AccruingPikOptionChange build();
	
	AccruingPikOptionChange.AccruingPikOptionChangeBuilder toBuilder();
	
	static AccruingPikOptionChange.AccruingPikOptionChangeBuilder builder() {
		return new AccruingPikOptionChange.AccruingPikOptionChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingPikOptionChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingPikOptionChange> getType() {
		return AccruingPikOptionChange.class;
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
		processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.class, getAccruingPikOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingPikOptionChangeBuilder extends AccruingPikOptionChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption();
		AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption();
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setComment(String comment);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setEffectiveDate(Date effectiveDate);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingPikOptionChange.AccruingPikOptionChangeBuilder setAccruingPikOption(AccruingPikOption accruingPikOption);

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
			processRosetta(path.newSubPath("accruingPikOption"), processor, AccruingPikOption.AccruingPikOptionBuilder.class, getAccruingPikOption());
		}
		

		AccruingPikOptionChange.AccruingPikOptionChangeBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingPikOptionChange  ***********************/
	class AccruingPikOptionChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingPikOptionChange {
		private final AccruingPikOption accruingPikOption;
		
		protected AccruingPikOptionChangeImpl(AccruingPikOptionChange.AccruingPikOptionChangeBuilder builder) {
			super(builder);
			this.accruingPikOption = ofNullable(builder.getAccruingPikOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accruingPikOption")
		public AccruingPikOption getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		public AccruingPikOptionChange build() {
			return this;
		}
		
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder toBuilder() {
			AccruingPikOptionChange.AccruingPikOptionChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingPikOptionChange.AccruingPikOptionChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccruingPikOption()).ifPresent(builder::setAccruingPikOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOptionChange {" +
				"accruingPikOption=" + this.accruingPikOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingPikOptionChange  ***********************/
	class AccruingPikOptionChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingPikOptionChange.AccruingPikOptionChangeBuilder {
	
		protected AccruingPikOption.AccruingPikOptionBuilder accruingPikOption;
	
		public AccruingPikOptionChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accruingPikOption")
		public AccruingPikOption.AccruingPikOptionBuilder getAccruingPikOption() {
			return accruingPikOption;
		}
		
		@Override
		public AccruingPikOption.AccruingPikOptionBuilder getOrCreateAccruingPikOption() {
			AccruingPikOption.AccruingPikOptionBuilder result;
			if (accruingPikOption!=null) {
				result = accruingPikOption;
			}
			else {
				result = accruingPikOption = AccruingPikOption.builder();
			}
			
			return result;
		}
		
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruingPikOption")
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder setAccruingPikOption(AccruingPikOption accruingPikOption) {
			this.accruingPikOption = accruingPikOption==null?null:accruingPikOption.toBuilder();
			return this;
		}
		
		@Override
		public AccruingPikOptionChange build() {
			return new AccruingPikOptionChange.AccruingPikOptionChangeImpl(this);
		}
		
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder prune() {
			super.prune();
			if (accruingPikOption!=null && !accruingPikOption.prune().hasData()) accruingPikOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccruingPikOption()!=null && getAccruingPikOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingPikOptionChange.AccruingPikOptionChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingPikOptionChange.AccruingPikOptionChangeBuilder o = (AccruingPikOptionChange.AccruingPikOptionChangeBuilder) other;
			
			merger.mergeRosetta(getAccruingPikOption(), o.getAccruingPikOption(), this::setAccruingPikOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingPikOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(accruingPikOption, _that.getAccruingPikOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accruingPikOption != null ? accruingPikOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingPikOptionChangeBuilder {" +
				"accruingPikOption=" + this.accruingPikOption +
			'}' + " " + super.toString();
		}
	}
}
