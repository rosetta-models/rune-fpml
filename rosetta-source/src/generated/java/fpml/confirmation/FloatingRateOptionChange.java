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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.FloatingRateOptionChange;
import fpml.confirmation.FloatingRateOptionChange.FloatingRateOptionChangeBuilder;
import fpml.confirmation.FloatingRateOptionChange.FloatingRateOptionChangeBuilderImpl;
import fpml.confirmation.FloatingRateOptionChange.FloatingRateOptionChangeImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.FloatingRateOptionChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing a change in a floating rate accrual option. In real terms - an example of this would be a margin rate change associated with the 3-Month LIBOR accrual option.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateOptionChange", builder=FloatingRateOptionChange.FloatingRateOptionChangeBuilderImpl.class, version="${project.version}")
public interface FloatingRateOptionChange extends AbstractFacilityEvent {

	FloatingRateOptionChangeMeta metaData = new FloatingRateOptionChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The latest version of the floating rate option.
	 */
	FloatingRateOption getFloatingRateOption();

	/*********************** Build Methods  ***********************/
	FloatingRateOptionChange build();
	
	FloatingRateOptionChange.FloatingRateOptionChangeBuilder toBuilder();
	
	static FloatingRateOptionChange.FloatingRateOptionChangeBuilder builder() {
		return new FloatingRateOptionChange.FloatingRateOptionChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateOptionChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateOptionChange> getType() {
		return FloatingRateOptionChange.class;
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
		processRosetta(path.newSubPath("floatingRateOption"), processor, FloatingRateOption.class, getFloatingRateOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateOptionChangeBuilder extends FloatingRateOptionChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FloatingRateOption.FloatingRateOptionBuilder getOrCreateFloatingRateOption();
		FloatingRateOption.FloatingRateOptionBuilder getFloatingRateOption();
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setComment(String comment);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setEffectiveDate(Date effectiveDate);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setFacilityReference(FacilityReference facilityReference);
		FloatingRateOptionChange.FloatingRateOptionChangeBuilder setFloatingRateOption(FloatingRateOption floatingRateOption);

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
			processRosetta(path.newSubPath("floatingRateOption"), processor, FloatingRateOption.FloatingRateOptionBuilder.class, getFloatingRateOption());
		}
		

		FloatingRateOptionChange.FloatingRateOptionChangeBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateOptionChange  ***********************/
	class FloatingRateOptionChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements FloatingRateOptionChange {
		private final FloatingRateOption floatingRateOption;
		
		protected FloatingRateOptionChangeImpl(FloatingRateOptionChange.FloatingRateOptionChangeBuilder builder) {
			super(builder);
			this.floatingRateOption = ofNullable(builder.getFloatingRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		public FloatingRateOption getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		public FloatingRateOptionChange build() {
			return this;
		}
		
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder toBuilder() {
			FloatingRateOptionChange.FloatingRateOptionChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateOptionChange.FloatingRateOptionChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateOption()).ifPresent(builder::setFloatingRateOption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionChange {" +
				"floatingRateOption=" + this.floatingRateOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateOptionChange  ***********************/
	class FloatingRateOptionChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements FloatingRateOptionChange.FloatingRateOptionChangeBuilder {
	
		protected FloatingRateOption.FloatingRateOptionBuilder floatingRateOption;
	
		public FloatingRateOptionChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateOption")
		public FloatingRateOption.FloatingRateOptionBuilder getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder getOrCreateFloatingRateOption() {
			FloatingRateOption.FloatingRateOptionBuilder result;
			if (floatingRateOption!=null) {
				result = floatingRateOption;
			}
			else {
				result = floatingRateOption = FloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateOption")
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder setFloatingRateOption(FloatingRateOption floatingRateOption) {
			this.floatingRateOption = floatingRateOption==null?null:floatingRateOption.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateOptionChange build() {
			return new FloatingRateOptionChange.FloatingRateOptionChangeImpl(this);
		}
		
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder prune() {
			super.prune();
			if (floatingRateOption!=null && !floatingRateOption.prune().hasData()) floatingRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateOption()!=null && getFloatingRateOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOptionChange.FloatingRateOptionChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateOptionChange.FloatingRateOptionChangeBuilder o = (FloatingRateOptionChange.FloatingRateOptionChangeBuilder) other;
			
			merger.mergeRosetta(getFloatingRateOption(), o.getFloatingRateOption(), this::setFloatingRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionChangeBuilder {" +
				"floatingRateOption=" + this.floatingRateOption +
			'}' + " " + super.toString();
		}
	}
}
