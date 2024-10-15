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
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.AdjustableDate2.AdjustableDate2Builder;
import fpml.confirmation.AdjustableDate2.AdjustableDate2BuilderImpl;
import fpml.confirmation.AdjustableDate2.AdjustableDate2Impl;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BusinessDayAdjustmentsReference;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.AdjustableDate2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that is different from AdjustableDate in two regards. First, date adjustments can be specified with either a dateAdjustments element or a reference to an existing dateAdjustments element. Second, it does not require the specification of date adjustments.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableDate2", builder=AdjustableDate2.AdjustableDate2BuilderImpl.class, version="${project.version}")
public interface AdjustableDate2 extends RosettaModelObject {

	AdjustableDate2Meta metaData = new AdjustableDate2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment.
	 */
	IdentifiedDate getUnadjustedDate();
	/**
	 * The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business dat in the specified business centers.
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 * A pointer style reference to date adjustments defined elsewhere in the document.
	 */
	BusinessDayAdjustmentsReference getDateAdjustmentsReference();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	IdentifiedDate getAdjustedDate();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableDate2 build();
	
	AdjustableDate2.AdjustableDate2Builder toBuilder();
	
	static AdjustableDate2.AdjustableDate2Builder builder() {
		return new AdjustableDate2.AdjustableDate2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDate2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDate2> getType() {
		return AdjustableDate2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("dateAdjustmentsReference"), processor, BusinessDayAdjustmentsReference.class, getDateAdjustmentsReference());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDate2Builder extends AdjustableDate2, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder getOrCreateDateAdjustmentsReference();
		BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder getDateAdjustmentsReference();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		AdjustableDate2.AdjustableDate2Builder setUnadjustedDate(IdentifiedDate unadjustedDate);
		AdjustableDate2.AdjustableDate2Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDate2.AdjustableDate2Builder setDateAdjustmentsReference(BusinessDayAdjustmentsReference dateAdjustmentsReference);
		AdjustableDate2.AdjustableDate2Builder setAdjustedDate(IdentifiedDate adjustedDate);
		AdjustableDate2.AdjustableDate2Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("dateAdjustmentsReference"), processor, BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder.class, getDateAdjustmentsReference());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableDate2.AdjustableDate2Builder prune();
	}

	/*********************** Immutable Implementation of AdjustableDate2  ***********************/
	class AdjustableDate2Impl implements AdjustableDate2 {
		private final IdentifiedDate unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final BusinessDayAdjustmentsReference dateAdjustmentsReference;
		private final IdentifiedDate adjustedDate;
		private final String id;
		
		protected AdjustableDate2Impl(AdjustableDate2.AdjustableDate2Builder builder) {
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.dateAdjustmentsReference = ofNullable(builder.getDateAdjustmentsReference()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("dateAdjustmentsReference")
		public BusinessDayAdjustmentsReference getDateAdjustmentsReference() {
			return dateAdjustmentsReference;
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
		public AdjustableDate2 build() {
			return this;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder toBuilder() {
			AdjustableDate2.AdjustableDate2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDate2.AdjustableDate2Builder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getDateAdjustmentsReference()).ifPresent(builder::setDateAdjustmentsReference);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate2 _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(dateAdjustmentsReference, _that.getDateAdjustmentsReference())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentsReference != null ? dateAdjustmentsReference.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDate2 {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"dateAdjustmentsReference=" + this.dateAdjustmentsReference + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDate2  ***********************/
	class AdjustableDate2BuilderImpl implements AdjustableDate2.AdjustableDate2Builder {
	
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder dateAdjustmentsReference;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
		protected String id;
	
		public AdjustableDate2BuilderImpl() {
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
		@RosettaAttribute("dateAdjustmentsReference")
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder getDateAdjustmentsReference() {
			return dateAdjustmentsReference;
		}
		
		@Override
		public BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder getOrCreateDateAdjustmentsReference() {
			BusinessDayAdjustmentsReference.BusinessDayAdjustmentsReferenceBuilder result;
			if (dateAdjustmentsReference!=null) {
				result = dateAdjustmentsReference;
			}
			else {
				result = dateAdjustmentsReference = BusinessDayAdjustmentsReference.builder();
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
		public AdjustableDate2.AdjustableDate2Builder setUnadjustedDate(IdentifiedDate unadjustedDate) {
			this.unadjustedDate = unadjustedDate==null?null:unadjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public AdjustableDate2.AdjustableDate2Builder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustmentsReference")
		public AdjustableDate2.AdjustableDate2Builder setDateAdjustmentsReference(BusinessDayAdjustmentsReference dateAdjustmentsReference) {
			this.dateAdjustmentsReference = dateAdjustmentsReference==null?null:dateAdjustmentsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public AdjustableDate2.AdjustableDate2Builder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableDate2.AdjustableDate2Builder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableDate2 build() {
			return new AdjustableDate2.AdjustableDate2Impl(this);
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate2.AdjustableDate2Builder prune() {
			if (unadjustedDate!=null && !unadjustedDate.prune().hasData()) unadjustedDate = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (dateAdjustmentsReference!=null && !dateAdjustmentsReference.prune().hasData()) dateAdjustmentsReference = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null && getUnadjustedDate().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getDateAdjustmentsReference()!=null && getDateAdjustmentsReference().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDate2.AdjustableDate2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDate2.AdjustableDate2Builder o = (AdjustableDate2.AdjustableDate2Builder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getDateAdjustmentsReference(), o.getDateAdjustmentsReference(), this::setDateAdjustmentsReference);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDate2 _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(dateAdjustmentsReference, _that.getDateAdjustmentsReference())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (dateAdjustmentsReference != null ? dateAdjustmentsReference.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDate2Builder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"dateAdjustmentsReference=" + this.dateAdjustmentsReference + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
