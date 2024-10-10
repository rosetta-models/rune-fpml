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
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder;
import fpml.confirmation.AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl;
import fpml.confirmation.AdjustableOrAdjustedDate.AdjustableOrAdjustedDateImpl;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.meta.AdjustableOrAdjustedDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableOrAdjustedDate", builder=AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl.class, version="${project.version}")
public interface AdjustableOrAdjustedDate extends RosettaModelObject {

	AdjustableOrAdjustedDateMeta metaData = new AdjustableOrAdjustedDateMeta();

	/*********************** Getter Methods  ***********************/
	AdjustableDateModel getAdjustableDateModel();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	IdentifiedDate getAdjustedDate();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableOrAdjustedDate build();
	
	AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder();
	
	static AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder() {
		return new AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrAdjustedDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableOrAdjustedDate> getType() {
		return AdjustableOrAdjustedDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDateModel"), processor, AdjustableDateModel.class, getAdjustableDateModel());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrAdjustedDateBuilder extends AdjustableOrAdjustedDate, RosettaModelObjectBuilder {
		AdjustableDateModel.AdjustableDateModelBuilder getOrCreateAdjustableDateModel();
		AdjustableDateModel.AdjustableDateModelBuilder getAdjustableDateModel();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate();
		IdentifiedDate.IdentifiedDateBuilder getAdjustedDate();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustableDateModel(AdjustableDateModel adjustableDateModel);
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustedDate(IdentifiedDate adjustedDate);
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDateModel"), processor, AdjustableDateModel.AdjustableDateModelBuilder.class, getAdjustableDateModel());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrAdjustedDate  ***********************/
	class AdjustableOrAdjustedDateImpl implements AdjustableOrAdjustedDate {
		private final AdjustableDateModel adjustableDateModel;
		private final IdentifiedDate adjustedDate;
		private final String id;
		
		protected AdjustableOrAdjustedDateImpl(AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder) {
			this.adjustableDateModel = ofNullable(builder.getAdjustableDateModel()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDateModel")
		public AdjustableDateModel getAdjustableDateModel() {
			return adjustableDateModel;
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
		public AdjustableOrAdjustedDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder builder) {
			ofNullable(getAdjustableDateModel()).ifPresent(builder::setAdjustableDateModel);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDateModel, _that.getAdjustableDateModel())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDateModel != null ? adjustableDateModel.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedDate {" +
				"adjustableDateModel=" + this.adjustableDateModel + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrAdjustedDate  ***********************/
	class AdjustableOrAdjustedDateBuilderImpl implements AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder {
	
		protected AdjustableDateModel.AdjustableDateModelBuilder adjustableDateModel;
		protected IdentifiedDate.IdentifiedDateBuilder adjustedDate;
		protected String id;
	
		public AdjustableOrAdjustedDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustableDateModel")
		public AdjustableDateModel.AdjustableDateModelBuilder getAdjustableDateModel() {
			return adjustableDateModel;
		}
		
		@Override
		public AdjustableDateModel.AdjustableDateModelBuilder getOrCreateAdjustableDateModel() {
			AdjustableDateModel.AdjustableDateModelBuilder result;
			if (adjustableDateModel!=null) {
				result = adjustableDateModel;
			}
			else {
				result = adjustableDateModel = AdjustableDateModel.builder();
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
		@RosettaAttribute("adjustableDateModel")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustableDateModel(AdjustableDateModel adjustableDateModel) {
			this.adjustableDateModel = adjustableDateModel==null?null:adjustableDateModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableOrAdjustedDate build() {
			return new AdjustableOrAdjustedDate.AdjustableOrAdjustedDateImpl(this);
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder prune() {
			if (adjustableDateModel!=null && !adjustableDateModel.prune().hasData()) adjustableDateModel = null;
			if (adjustedDate!=null && !adjustedDate.prune().hasData()) adjustedDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDateModel()!=null && getAdjustableDateModel().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder o = (AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDateModel(), o.getAdjustableDateModel(), this::setAdjustableDateModel);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrAdjustedDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDateModel, _that.getAdjustableDateModel())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDateModel != null ? adjustableDateModel.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrAdjustedDateBuilder {" +
				"adjustableDateModel=" + this.adjustableDateModel + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
