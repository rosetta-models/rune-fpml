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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AdjustableDate.AdjustableDateBuilder;
import fpml.confirmation.AdjustableDate.AdjustableDateBuilderImpl;
import fpml.confirmation.AdjustableDate.AdjustableDateImpl;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.AdjustableDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AdjustableDate", builder=AdjustableDate.AdjustableDateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AdjustableDate extends RosettaModelObject {

	AdjustableDateMeta metaData = new AdjustableDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment.
	 */
	IdentifiedDate getUnadjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	IdentifiedDate getAdjustedDate();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableDate build();
	
	AdjustableDate.AdjustableDateBuilder toBuilder();
	
	static AdjustableDate.AdjustableDateBuilder builder() {
		return new AdjustableDate.AdjustableDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDate> getType() {
		return AdjustableDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDateBuilder extends AdjustableDate, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		AdjustableDate.AdjustableDateBuilder setUnadjustedDate(IdentifiedDate unadjustedDate);
		AdjustableDate.AdjustableDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDate.AdjustableDateBuilder setAdjustedDate(IdentifiedDate adjustedDate);
		AdjustableDate.AdjustableDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableDate.AdjustableDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDate  ***********************/
	class AdjustableDateImpl implements AdjustableDate {
		private final IdentifiedDate unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final IdentifiedDate adjustedDate;
		private final String id;
		
		protected AdjustableDateImpl(AdjustableDate.AdjustableDateBuilder builder) {
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		public IdentifiedDate getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public IdentifiedDate getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableDate build() {
			return this;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder toBuilder() {
			AdjustableDate.AdjustableDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDate.AdjustableDateBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDate {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDate  ***********************/
	class AdjustableDateBuilderImpl implements AdjustableDate.AdjustableDateBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
		protected String id;
	
		public AdjustableDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (unadjustedDate!=null) {
				result = unadjustedDate;
			}
			else {
				result = unadjustedDate = IdentifiedDate.builder();
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
		@RosettaAttribute("adjustedDate")
		public IdentifiedDate.IdentifiedDateBuilder getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (adjustedDate!=null) {
				result = adjustedDate;
			}
			else {
				result = adjustedDate = IdentifiedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		public AdjustableDate.AdjustableDateBuilder setUnadjustedDate(IdentifiedDate unadjustedDate) {
			this.unadjustedDate = unadjustedDate==null?null:unadjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public AdjustableDate.AdjustableDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public AdjustableDate.AdjustableDateBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableDate.AdjustableDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableDate build() {
			return new AdjustableDate.AdjustableDateImpl(this);
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate.AdjustableDateBuilder prune() {
			if (unadjustedDate!=null && !unadjustedDate.prune().hasData()) unadjustedDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null && getUnadjustedDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate.AdjustableDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDate.AdjustableDateBuilder o = (AdjustableDate.AdjustableDateBuilder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
