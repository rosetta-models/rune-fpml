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
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.FixedRateOptionChange;
import fpml.confirmation.FixedRateOptionChange.FixedRateOptionChangeBuilder;
import fpml.confirmation.FixedRateOptionChange.FixedRateOptionChangeBuilderImpl;
import fpml.confirmation.FixedRateOptionChange.FixedRateOptionChangeImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.FixedRateOptionChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in a fixed rate accrual option. In real terms - an example of this would be a margin rate change.
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRateOptionChange", builder=FixedRateOptionChange.FixedRateOptionChangeBuilderImpl.class, version="${project.version}")
public interface FixedRateOptionChange extends AbstractFacilityEvent {

	FixedRateOptionChangeMeta metaData = new FixedRateOptionChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The latest version of the fixed rate option.
	 */
	FixedRateOption getFixedRateOption();

	/*********************** Build Methods  ***********************/
	FixedRateOptionChange build();
	
	FixedRateOptionChange.FixedRateOptionChangeBuilder toBuilder();
	
	static FixedRateOptionChange.FixedRateOptionChangeBuilder builder() {
		return new FixedRateOptionChange.FixedRateOptionChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRateOptionChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedRateOptionChange> getType() {
		return FixedRateOptionChange.class;
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
		processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.class, getFixedRateOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRateOptionChangeBuilder extends FixedRateOptionChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption();
		FixedRateOption.FixedRateOptionBuilder getFixedRateOption();
		FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setComment(String comment);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setEffectiveDate(Date effectiveDate);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setFacilityReference(FacilityReference facilityReference);
		FixedRateOptionChange.FixedRateOptionChangeBuilder setFixedRateOption(FixedRateOption fixedRateOption);

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
			processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.FixedRateOptionBuilder.class, getFixedRateOption());
		}
		

		FixedRateOptionChange.FixedRateOptionChangeBuilder prune();
	}

	/*********************** Immutable Implementation of FixedRateOptionChange  ***********************/
	class FixedRateOptionChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements FixedRateOptionChange {
		private final FixedRateOption fixedRateOption;
		
		protected FixedRateOptionChangeImpl(FixedRateOptionChange.FixedRateOptionChangeBuilder builder) {
			super(builder);
			this.fixedRateOption = ofNullable(builder.getFixedRateOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateOption")
		public FixedRateOption getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		public FixedRateOptionChange build() {
			return this;
		}
		
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder toBuilder() {
			FixedRateOptionChange.FixedRateOptionChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRateOptionChange.FixedRateOptionChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixedRateOption()).ifPresent(builder::setFixedRateOption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOptionChange {" +
				"fixedRateOption=" + this.fixedRateOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FixedRateOptionChange  ***********************/
	class FixedRateOptionChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements FixedRateOptionChange.FixedRateOptionChangeBuilder {
	
		protected FixedRateOption.FixedRateOptionBuilder fixedRateOption;
	
		public FixedRateOptionChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRateOption")
		public FixedRateOption.FixedRateOptionBuilder getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption() {
			FixedRateOption.FixedRateOptionBuilder result;
			if (fixedRateOption!=null) {
				result = fixedRateOption;
			}
			else {
				result = fixedRateOption = FixedRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public FixedRateOptionChange.FixedRateOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRateOption")
		public FixedRateOptionChange.FixedRateOptionChangeBuilder setFixedRateOption(FixedRateOption fixedRateOption) {
			this.fixedRateOption = fixedRateOption==null?null:fixedRateOption.toBuilder();
			return this;
		}
		
		@Override
		public FixedRateOptionChange build() {
			return new FixedRateOptionChange.FixedRateOptionChangeImpl(this);
		}
		
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder prune() {
			super.prune();
			if (fixedRateOption!=null && !fixedRateOption.prune().hasData()) fixedRateOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixedRateOption()!=null && getFixedRateOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRateOptionChange.FixedRateOptionChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FixedRateOptionChange.FixedRateOptionChangeBuilder o = (FixedRateOptionChange.FixedRateOptionChangeBuilder) other;
			
			merger.mergeRosetta(getFixedRateOption(), o.getFixedRateOption(), this::setFixedRateOption);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FixedRateOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRateOptionChangeBuilder {" +
				"fixedRateOption=" + this.fixedRateOption +
			'}' + " " + super.toString();
		}
	}
}
