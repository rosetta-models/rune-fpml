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
import fpml.confirmation.AssetReference;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.DividendPeriod;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilder;
import fpml.confirmation.DividendPeriod.DividendPeriodBuilderImpl;
import fpml.confirmation.DividendPeriod.DividendPeriodImpl;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.DividendPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class of all time bounded dividend period types.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendPeriod", builder=DividendPeriod.DividendPeriodBuilderImpl.class, version="${project.version}")
public interface DividendPeriod extends RosettaModelObject {

	DividendPeriodMeta metaData = new DividendPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unadjusted inclusive dividend period start date.
	 */
	IdentifiedDate getUnadjustedStartDate();
	/**
	 * Unadjusted inclusive dividend period end date.
	 */
	IdentifiedDate getUnadjustedEndDate();
	/**
	 * Date adjustments for all unadjusted dates in this dividend period.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * Reference to the underlyer which is paying dividends. This should be used in all cases, and must be used where there are multiple underlying assets, to avoid any ambiguity about which asset the dividend period relates to.
	 */
	AssetReference getUnderlyerReference();
	String getId();

	/*********************** Build Methods  ***********************/
	DividendPeriod build();
	
	DividendPeriod.DividendPeriodBuilder toBuilder();
	
	static DividendPeriod.DividendPeriodBuilder builder() {
		return new DividendPeriod.DividendPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPeriod> getType() {
		return DividendPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.class, getUnadjustedStartDate());
		processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.class, getUnadjustedEndDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPeriodBuilder extends DividendPeriod, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedStartDate();
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedStartDate();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedEndDate();
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedEndDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference();
		AssetReference.AssetReferenceBuilder getUnderlyerReference();
		DividendPeriod.DividendPeriodBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate);
		DividendPeriod.DividendPeriodBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate);
		DividendPeriod.DividendPeriodBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		DividendPeriod.DividendPeriodBuilder setUnderlyerReference(AssetReference underlyerReference);
		DividendPeriod.DividendPeriodBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedStartDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedStartDate());
			processRosetta(path.newSubPath("unadjustedEndDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedEndDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		DividendPeriod.DividendPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPeriod  ***********************/
	class DividendPeriodImpl implements DividendPeriod {
		private final IdentifiedDate unadjustedStartDate;
		private final IdentifiedDate unadjustedEndDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final AssetReference underlyerReference;
		private final String id;
		
		protected DividendPeriodImpl(DividendPeriod.DividendPeriodBuilder builder) {
			this.unadjustedStartDate = ofNullable(builder.getUnadjustedStartDate()).map(f->f.build()).orElse(null);
			this.unadjustedEndDate = ofNullable(builder.getUnadjustedEndDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		public IdentifiedDate getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		public IdentifiedDate getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public AssetReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public DividendPeriod build() {
			return this;
		}
		
		@Override
		public DividendPeriod.DividendPeriodBuilder toBuilder() {
			DividendPeriod.DividendPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPeriod.DividendPeriodBuilder builder) {
			ofNullable(getUnadjustedStartDate()).ifPresent(builder::setUnadjustedStartDate);
			ofNullable(getUnadjustedEndDate()).ifPresent(builder::setUnadjustedEndDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPeriod _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriod {" +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPeriod  ***********************/
	class DividendPeriodBuilderImpl implements DividendPeriod.DividendPeriodBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedStartDate;
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedEndDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected AssetReference.AssetReferenceBuilder underlyerReference;
		protected String id;
	
		public DividendPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedStartDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedStartDate() {
			return unadjustedStartDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedStartDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedStartDate!=null) {
				result = unadjustedStartDate;
			}
			else {
				result = unadjustedStartDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unadjustedEndDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedEndDate() {
			return unadjustedEndDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedEndDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedEndDate!=null) {
				result = unadjustedEndDate;
			}
			else {
				result = unadjustedEndDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public AssetReference.AssetReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedStartDate")
		public DividendPeriod.DividendPeriodBuilder setUnadjustedStartDate(IdentifiedDate unadjustedStartDate) {
			this.unadjustedStartDate = unadjustedStartDate==null?null:unadjustedStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("unadjustedEndDate")
		public DividendPeriod.DividendPeriodBuilder setUnadjustedEndDate(IdentifiedDate unadjustedEndDate) {
			this.unadjustedEndDate = unadjustedEndDate==null?null:unadjustedEndDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public DividendPeriod.DividendPeriodBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public DividendPeriod.DividendPeriodBuilder setUnderlyerReference(AssetReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DividendPeriod.DividendPeriodBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public DividendPeriod build() {
			return new DividendPeriod.DividendPeriodImpl(this);
		}
		
		@Override
		public DividendPeriod.DividendPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriod.DividendPeriodBuilder prune() {
			if (unadjustedStartDate!=null && !unadjustedStartDate.prune().hasData()) unadjustedStartDate = null;
			if (unadjustedEndDate!=null && !unadjustedEndDate.prune().hasData()) unadjustedEndDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedStartDate()!=null && getUnadjustedStartDate().hasData()) return true;
			if (getUnadjustedEndDate()!=null && getUnadjustedEndDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPeriod.DividendPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPeriod.DividendPeriodBuilder o = (DividendPeriod.DividendPeriodBuilder) other;
			
			merger.mergeRosetta(getUnadjustedStartDate(), o.getUnadjustedStartDate(), this::setUnadjustedStartDate);
			merger.mergeRosetta(getUnadjustedEndDate(), o.getUnadjustedEndDate(), this::setUnadjustedEndDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPeriod _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedStartDate, _that.getUnadjustedStartDate())) return false;
			if (!Objects.equals(unadjustedEndDate, _that.getUnadjustedEndDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedStartDate != null ? unadjustedStartDate.hashCode() : 0);
			_result = 31 * _result + (unadjustedEndDate != null ? unadjustedEndDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPeriodBuilder {" +
				"unadjustedStartDate=" + this.unadjustedStartDate + ", " +
				"unadjustedEndDate=" + this.unadjustedEndDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
