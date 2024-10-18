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
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.AccruingFeeExpiry;
import fpml.confirmation.AccruingFeeExpiry.AccruingFeeExpiryBuilder;
import fpml.confirmation.AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl;
import fpml.confirmation.AccruingFeeExpiry.AccruingFeeExpiryImpl;
import fpml.confirmation.AccruingFeeType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.AccruingFeeExpiryMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event describing a future expiry of one of the accruing fees associated with a specific facility.
 * @version ${project.version}
 */
@RosettaDataType(value="AccruingFeeExpiry", builder=AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl.class, version="${project.version}")
public interface AccruingFeeExpiry extends AbstractFacilityEvent {

	AccruingFeeExpiryMeta metaData = new AccruingFeeExpiryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id associated with the loan accrual type.
	 */
	AccrualTypeId getId();
	/**
	 * The accruing fee type which ix expiring.
	 */
	AccruingFeeType get_type();

	/*********************** Build Methods  ***********************/
	AccruingFeeExpiry build();
	
	AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder();
	
	static AccruingFeeExpiry.AccruingFeeExpiryBuilder builder() {
		return new AccruingFeeExpiry.AccruingFeeExpiryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccruingFeeExpiry> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccruingFeeExpiry> getType() {
		return AccruingFeeExpiry.class;
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
		processRosetta(path.newSubPath("id"), processor, AccrualTypeId.class, getId());
		processRosetta(path.newSubPath("_type"), processor, AccruingFeeType.class, get_type());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccruingFeeExpiryBuilder extends AccruingFeeExpiry, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateId();
		AccrualTypeId.AccrualTypeIdBuilder getId();
		AccruingFeeType.AccruingFeeTypeBuilder getOrCreate_type();
		AccruingFeeType.AccruingFeeTypeBuilder get_type();
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setComment(String comment);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setEffectiveDate(Date effectiveDate);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setFacilityReference(FacilityReference facilityReference);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder setId(AccrualTypeId id);
		AccruingFeeExpiry.AccruingFeeExpiryBuilder set_type(AccruingFeeType _type);

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
			processRosetta(path.newSubPath("id"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getId());
			processRosetta(path.newSubPath("_type"), processor, AccruingFeeType.AccruingFeeTypeBuilder.class, get_type());
		}
		

		AccruingFeeExpiry.AccruingFeeExpiryBuilder prune();
	}

	/*********************** Immutable Implementation of AccruingFeeExpiry  ***********************/
	class AccruingFeeExpiryImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements AccruingFeeExpiry {
		private final AccrualTypeId id;
		private final AccruingFeeType _type;
		
		protected AccruingFeeExpiryImpl(AccruingFeeExpiry.AccruingFeeExpiryBuilder builder) {
			super(builder);
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		public AccrualTypeId getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeType get_type() {
			return _type;
		}
		
		@Override
		public AccruingFeeExpiry build() {
			return this;
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder() {
			AccruingFeeExpiry.AccruingFeeExpiryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccruingFeeExpiry.AccruingFeeExpiryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeExpiry _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeExpiry {" +
				"id=" + this.id + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AccruingFeeExpiry  ***********************/
	class AccruingFeeExpiryBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements AccruingFeeExpiry.AccruingFeeExpiryBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder id;
		protected AccruingFeeType.AccruingFeeTypeBuilder _type;
	
		public AccruingFeeExpiryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public AccrualTypeId.AccrualTypeIdBuilder getId() {
			return id;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeType.AccruingFeeTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public AccruingFeeType.AccruingFeeTypeBuilder getOrCreate_type() {
			AccruingFeeType.AccruingFeeTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = AccruingFeeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder setId(AccrualTypeId id) {
			this.id = id==null?null:id.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder set_type(AccruingFeeType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		
		@Override
		public AccruingFeeExpiry build() {
			return new AccruingFeeExpiry.AccruingFeeExpiryImpl(this);
		}
		
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder prune() {
			super.prune();
			if (id!=null && !id.prune().hasData()) id = null;
			if (_type!=null && !_type.prune().hasData()) _type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getId()!=null && getId().hasData()) return true;
			if (get_type()!=null && get_type().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccruingFeeExpiry.AccruingFeeExpiryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AccruingFeeExpiry.AccruingFeeExpiryBuilder o = (AccruingFeeExpiry.AccruingFeeExpiryBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AccruingFeeExpiry _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccruingFeeExpiryBuilder {" +
				"id=" + this.id + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}
}
