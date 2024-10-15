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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.BusinessDateRange;
import fpml.confirmation.CashSettlementPaymentDate;
import fpml.confirmation.CashSettlementPaymentDate.CashSettlementPaymentDateBuilder;
import fpml.confirmation.CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl;
import fpml.confirmation.CashSettlementPaymentDate.CashSettlementPaymentDateImpl;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.CashSettlementPaymentDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the cash settlement payment date(s) as either a set of explicit dates, together with applicable adjustments, or as a date relative to some other (anchor) date, or as any date in a range of contiguous business days.
 * @version ${project.version}
 */
@RosettaDataType(value="CashSettlementPaymentDate", builder=CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl.class, version="${project.version}")
public interface CashSettlementPaymentDate extends RosettaModelObject {

	CashSettlementPaymentDateMeta metaData = new CashSettlementPaymentDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDates getAdjustableDates();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();
	/**
	 * A range of contiguous business days.
	 */
	BusinessDateRange getBusinessDateRange();
	String getId();

	/*********************** Build Methods  ***********************/
	CashSettlementPaymentDate build();
	
	CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder();
	
	static CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder() {
		return new CashSettlementPaymentDate.CashSettlementPaymentDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementPaymentDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashSettlementPaymentDate> getType() {
		return CashSettlementPaymentDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
		processRosetta(path.newSubPath("businessDateRange"), processor, BusinessDateRange.class, getBusinessDateRange());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementPaymentDateBuilder extends CashSettlementPaymentDate, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		BusinessDateRange.BusinessDateRangeBuilder getOrCreateBusinessDateRange();
		BusinessDateRange.BusinessDateRangeBuilder getBusinessDateRange();
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setAdjustableDates(AdjustableDates adjustableDates);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setRelativeDate(RelativeDateOffset relativeDate);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setBusinessDateRange(BusinessDateRange businessDateRange);
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
			processRosetta(path.newSubPath("businessDateRange"), processor, BusinessDateRange.BusinessDateRangeBuilder.class, getBusinessDateRange());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementPaymentDate  ***********************/
	class CashSettlementPaymentDateImpl implements CashSettlementPaymentDate {
		private final AdjustableDates adjustableDates;
		private final RelativeDateOffset relativeDate;
		private final BusinessDateRange businessDateRange;
		private final String id;
		
		protected CashSettlementPaymentDateImpl(CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
			this.businessDateRange = ofNullable(builder.getBusinessDateRange()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		@RosettaAttribute("businessDateRange")
		public BusinessDateRange getBusinessDateRange() {
			return businessDateRange;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CashSettlementPaymentDate build() {
			return this;
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder() {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementPaymentDate.CashSettlementPaymentDateBuilder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
			ofNullable(getBusinessDateRange()).ifPresent(builder::setBusinessDateRange);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(businessDateRange, _that.getBusinessDateRange())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (businessDateRange != null ? businessDateRange.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementPaymentDate {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"businessDateRange=" + this.businessDateRange + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlementPaymentDate  ***********************/
	class CashSettlementPaymentDateBuilderImpl implements CashSettlementPaymentDate.CashSettlementPaymentDateBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		protected BusinessDateRange.BusinessDateRangeBuilder businessDateRange;
		protected String id;
	
		public CashSettlementPaymentDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessDateRange")
		public BusinessDateRange.BusinessDateRangeBuilder getBusinessDateRange() {
			return businessDateRange;
		}
		
		@Override
		public BusinessDateRange.BusinessDateRangeBuilder getOrCreateBusinessDateRange() {
			BusinessDateRange.BusinessDateRangeBuilder result;
			if (businessDateRange!=null) {
				result = businessDateRange;
			}
			else {
				result = businessDateRange = BusinessDateRange.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setAdjustableDates(AdjustableDates adjustableDates) {
			this.adjustableDates = adjustableDates==null?null:adjustableDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDate")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessDateRange")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setBusinessDateRange(BusinessDateRange businessDateRange) {
			this.businessDateRange = businessDateRange==null?null:businessDateRange.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CashSettlementPaymentDate build() {
			return new CashSettlementPaymentDate.CashSettlementPaymentDateImpl(this);
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			if (businessDateRange!=null && !businessDateRange.prune().hasData()) businessDateRange = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			if (getBusinessDateRange()!=null && getBusinessDateRange().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder o = (CashSettlementPaymentDate.CashSettlementPaymentDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			merger.mergeRosetta(getBusinessDateRange(), o.getBusinessDateRange(), this::setBusinessDateRange);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(businessDateRange, _that.getBusinessDateRange())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (businessDateRange != null ? businessDateRange.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementPaymentDateBuilder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"businessDateRange=" + this.businessDateRange + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
