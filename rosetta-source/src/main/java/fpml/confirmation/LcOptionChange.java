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
import fpml.confirmation.LcOption;
import fpml.confirmation.LcOptionChange;
import fpml.confirmation.LcOptionChange.LcOptionChangeBuilder;
import fpml.confirmation.LcOptionChange.LcOptionChangeBuilderImpl;
import fpml.confirmation.LcOptionChange.LcOptionChangeImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.LcOptionChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in an L/C accrual option. In real terms - an example of this would be an L/C margin rate change.
 * @version ${project.version}
 */
@RosettaDataType(value="LcOptionChange", builder=LcOptionChange.LcOptionChangeBuilderImpl.class, version="${project.version}")
public interface LcOptionChange extends AbstractFacilityEvent {

	LcOptionChangeMeta metaData = new LcOptionChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The latest version of the letter of credit option.
	 */
	LcOption getLcOption();

	/*********************** Build Methods  ***********************/
	LcOptionChange build();
	
	LcOptionChange.LcOptionChangeBuilder toBuilder();
	
	static LcOptionChange.LcOptionChangeBuilder builder() {
		return new LcOptionChange.LcOptionChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcOptionChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcOptionChange> getType() {
		return LcOptionChange.class;
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
		processRosetta(path.newSubPath("lcOption"), processor, LcOption.class, getLcOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcOptionChangeBuilder extends LcOptionChange, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		LcOption.LcOptionBuilder getOrCreateLcOption();
		LcOption.LcOptionBuilder getLcOption();
		LcOptionChange.LcOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcOptionChange.LcOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcOptionChange.LcOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcOptionChange.LcOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcOptionChange.LcOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcOptionChange.LcOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcOptionChange.LcOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcOptionChange.LcOptionChangeBuilder setComment(String comment);
		LcOptionChange.LcOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcOptionChange.LcOptionChangeBuilder setEffectiveDate(Date effectiveDate);
		LcOptionChange.LcOptionChangeBuilder setFacilityReference(FacilityReference facilityReference);
		LcOptionChange.LcOptionChangeBuilder setLcOption(LcOption lcOption);

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
			processRosetta(path.newSubPath("lcOption"), processor, LcOption.LcOptionBuilder.class, getLcOption());
		}
		

		LcOptionChange.LcOptionChangeBuilder prune();
	}

	/*********************** Immutable Implementation of LcOptionChange  ***********************/
	class LcOptionChangeImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements LcOptionChange {
		private final LcOption lcOption;
		
		protected LcOptionChangeImpl(LcOptionChange.LcOptionChangeBuilder builder) {
			super(builder);
			this.lcOption = ofNullable(builder.getLcOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcOption")
		public LcOption getLcOption() {
			return lcOption;
		}
		
		@Override
		public LcOptionChange build() {
			return this;
		}
		
		@Override
		public LcOptionChange.LcOptionChangeBuilder toBuilder() {
			LcOptionChange.LcOptionChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcOptionChange.LcOptionChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcOption()).ifPresent(builder::setLcOption);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOptionChange {" +
				"lcOption=" + this.lcOption +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcOptionChange  ***********************/
	class LcOptionChangeBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements LcOptionChange.LcOptionChangeBuilder {
	
		protected LcOption.LcOptionBuilder lcOption;
	
		public LcOptionChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lcOption")
		public LcOption.LcOptionBuilder getLcOption() {
			return lcOption;
		}
		
		@Override
		public LcOption.LcOptionBuilder getOrCreateLcOption() {
			LcOption.LcOptionBuilder result;
			if (lcOption!=null) {
				result = lcOption;
			}
			else {
				result = lcOption = LcOption.builder();
			}
			
			return result;
		}
		
		@Override
		public LcOptionChange.LcOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcOptionChange.LcOptionChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcOptionChange.LcOptionChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LcOptionChange.LcOptionChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcOptionChange.LcOptionChangeBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcOptionChange.LcOptionChangeBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcOptionChange.LcOptionChangeBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcOptionChange.LcOptionChangeBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcOptionChange.LcOptionChangeBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcOptionChange.LcOptionChangeBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public LcOptionChange.LcOptionChangeBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcOption")
		public LcOptionChange.LcOptionChangeBuilder setLcOption(LcOption lcOption) {
			this.lcOption = lcOption==null?null:lcOption.toBuilder();
			return this;
		}
		
		@Override
		public LcOptionChange build() {
			return new LcOptionChange.LcOptionChangeImpl(this);
		}
		
		@Override
		public LcOptionChange.LcOptionChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOptionChange.LcOptionChangeBuilder prune() {
			super.prune();
			if (lcOption!=null && !lcOption.prune().hasData()) lcOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcOption()!=null && getLcOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcOptionChange.LcOptionChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcOptionChange.LcOptionChangeBuilder o = (LcOptionChange.LcOptionChangeBuilder) other;
			
			merger.mergeRosetta(getLcOption(), o.getLcOption(), this::setLcOption);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcOptionChange _that = getType().cast(o);
		
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcOptionChangeBuilder {" +
				"lcOption=" + this.lcOption +
			'}' + " " + super.toString();
		}
	}
}
