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
import fpml.confirmation.AdjustableDateModel;
import fpml.confirmation.AdjustableDateModel.AdjustableDateModelBuilder;
import fpml.confirmation.AdjustableDateModel.AdjustableDateModelBuilderImpl;
import fpml.confirmation.AdjustableDateModel.AdjustableDateModelImpl;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.AdjustableDateModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableDateModel", builder=AdjustableDateModel.AdjustableDateModelBuilderImpl.class, version="${project.version}")
public interface AdjustableDateModel extends RosettaModelObject {

	AdjustableDateModelMeta metaData = new AdjustableDateModelMeta();

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

	/*********************** Build Methods  ***********************/
	AdjustableDateModel build();
	
	AdjustableDateModel.AdjustableDateModelBuilder toBuilder();
	
	static AdjustableDateModel.AdjustableDateModelBuilder builder() {
		return new AdjustableDateModel.AdjustableDateModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDateModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDateModel> getType() {
		return AdjustableDateModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDateModelBuilder extends AdjustableDateModel, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		AdjustableDateModel.AdjustableDateModelBuilder setUnadjustedDate(IdentifiedDate unadjustedDate);
		AdjustableDateModel.AdjustableDateModelBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDateModel.AdjustableDateModelBuilder setAdjustedDate(IdentifiedDate adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
		}
		

		AdjustableDateModel.AdjustableDateModelBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDateModel  ***********************/
	class AdjustableDateModelImpl implements AdjustableDateModel {
		private final IdentifiedDate unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final IdentifiedDate adjustedDate;
		
		protected AdjustableDateModelImpl(AdjustableDateModel.AdjustableDateModelBuilder builder) {
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
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
		public AdjustableDateModel build() {
			return this;
		}
		
		@Override
		public AdjustableDateModel.AdjustableDateModelBuilder toBuilder() {
			AdjustableDateModel.AdjustableDateModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDateModel.AdjustableDateModelBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateModel _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateModel {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDateModel  ***********************/
	class AdjustableDateModelBuilderImpl implements AdjustableDateModel.AdjustableDateModelBuilder {
	
		protected IdentifiedDate.IdentifiedDateBuilder unadjustedDate;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
	
		public AdjustableDateModelBuilderImpl() {
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
		@RosettaAttribute("unadjustedDate")
		public AdjustableDateModel.AdjustableDateModelBuilder setUnadjustedDate(IdentifiedDate unadjustedDate) {
			this.unadjustedDate = unadjustedDate==null?null:unadjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateAdjustments")
		public AdjustableDateModel.AdjustableDateModelBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public AdjustableDateModel.AdjustableDateModelBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDateModel build() {
			return new AdjustableDateModel.AdjustableDateModelImpl(this);
		}
		
		@Override
		public AdjustableDateModel.AdjustableDateModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateModel.AdjustableDateModelBuilder prune() {
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
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateModel.AdjustableDateModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDateModel.AdjustableDateModelBuilder o = (AdjustableDateModel.AdjustableDateModelBuilder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateModel _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateModelBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
