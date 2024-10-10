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
import fpml.confirmation.DiscountRateModel;
import fpml.confirmation.Discounting;
import fpml.confirmation.Discounting.DiscountingBuilder;
import fpml.confirmation.Discounting.DiscountingBuilderImpl;
import fpml.confirmation.Discounting.DiscountingImpl;
import fpml.confirmation.DiscountingTypeEnum;
import fpml.confirmation.meta.DiscountingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
 * @version ${project.version}
 */
@RosettaDataType(value="Discounting", builder=Discounting.DiscountingBuilderImpl.class, version="${project.version}")
public interface Discounting extends RosettaModelObject {

	DiscountingMeta metaData = new DiscountingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The discounting method that is applicable.
	 */
	DiscountingTypeEnum getDiscountingType();
	DiscountRateModel getDiscountRateModel();

	/*********************** Build Methods  ***********************/
	Discounting build();
	
	Discounting.DiscountingBuilder toBuilder();
	
	static Discounting.DiscountingBuilder builder() {
		return new Discounting.DiscountingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Discounting> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Discounting> getType() {
		return Discounting.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
		processRosetta(path.newSubPath("discountRateModel"), processor, DiscountRateModel.class, getDiscountRateModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DiscountingBuilder extends Discounting, RosettaModelObjectBuilder {
		DiscountRateModel.DiscountRateModelBuilder getOrCreateDiscountRateModel();
		DiscountRateModel.DiscountRateModelBuilder getDiscountRateModel();
		Discounting.DiscountingBuilder setDiscountingType(DiscountingTypeEnum discountingType);
		Discounting.DiscountingBuilder setDiscountRateModel(DiscountRateModel discountRateModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("discountingType"), DiscountingTypeEnum.class, getDiscountingType(), this);
			processRosetta(path.newSubPath("discountRateModel"), processor, DiscountRateModel.DiscountRateModelBuilder.class, getDiscountRateModel());
		}
		

		Discounting.DiscountingBuilder prune();
	}

	/*********************** Immutable Implementation of Discounting  ***********************/
	class DiscountingImpl implements Discounting {
		private final DiscountingTypeEnum discountingType;
		private final DiscountRateModel discountRateModel;
		
		protected DiscountingImpl(Discounting.DiscountingBuilder builder) {
			this.discountingType = builder.getDiscountingType();
			this.discountRateModel = ofNullable(builder.getDiscountRateModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("discountingType")
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
		@Override
		@RosettaAttribute("discountRateModel")
		public DiscountRateModel getDiscountRateModel() {
			return discountRateModel;
		}
		
		@Override
		public Discounting build() {
			return this;
		}
		
		@Override
		public Discounting.DiscountingBuilder toBuilder() {
			Discounting.DiscountingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Discounting.DiscountingBuilder builder) {
			ofNullable(getDiscountingType()).ifPresent(builder::setDiscountingType);
			ofNullable(getDiscountRateModel()).ifPresent(builder::setDiscountRateModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Discounting _that = getType().cast(o);
		
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			if (!Objects.equals(discountRateModel, _that.getDiscountRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountRateModel != null ? discountRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Discounting {" +
				"discountingType=" + this.discountingType + ", " +
				"discountRateModel=" + this.discountRateModel +
			'}';
		}
	}

	/*********************** Builder Implementation of Discounting  ***********************/
	class DiscountingBuilderImpl implements Discounting.DiscountingBuilder {
	
		protected DiscountingTypeEnum discountingType;
		protected DiscountRateModel.DiscountRateModelBuilder discountRateModel;
	
		public DiscountingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("discountingType")
		public DiscountingTypeEnum getDiscountingType() {
			return discountingType;
		}
		
		@Override
		@RosettaAttribute("discountRateModel")
		public DiscountRateModel.DiscountRateModelBuilder getDiscountRateModel() {
			return discountRateModel;
		}
		
		@Override
		public DiscountRateModel.DiscountRateModelBuilder getOrCreateDiscountRateModel() {
			DiscountRateModel.DiscountRateModelBuilder result;
			if (discountRateModel!=null) {
				result = discountRateModel;
			}
			else {
				result = discountRateModel = DiscountRateModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("discountingType")
		public Discounting.DiscountingBuilder setDiscountingType(DiscountingTypeEnum discountingType) {
			this.discountingType = discountingType==null?null:discountingType;
			return this;
		}
		@Override
		@RosettaAttribute("discountRateModel")
		public Discounting.DiscountingBuilder setDiscountRateModel(DiscountRateModel discountRateModel) {
			this.discountRateModel = discountRateModel==null?null:discountRateModel.toBuilder();
			return this;
		}
		
		@Override
		public Discounting build() {
			return new Discounting.DiscountingImpl(this);
		}
		
		@Override
		public Discounting.DiscountingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Discounting.DiscountingBuilder prune() {
			if (discountRateModel!=null && !discountRateModel.prune().hasData()) discountRateModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDiscountingType()!=null) return true;
			if (getDiscountRateModel()!=null && getDiscountRateModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Discounting.DiscountingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Discounting.DiscountingBuilder o = (Discounting.DiscountingBuilder) other;
			
			merger.mergeRosetta(getDiscountRateModel(), o.getDiscountRateModel(), this::setDiscountRateModel);
			
			merger.mergeBasic(getDiscountingType(), o.getDiscountingType(), this::setDiscountingType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Discounting _that = getType().cast(o);
		
			if (!Objects.equals(discountingType, _that.getDiscountingType())) return false;
			if (!Objects.equals(discountRateModel, _that.getDiscountRateModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (discountingType != null ? discountingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (discountRateModel != null ? discountRateModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DiscountingBuilder {" +
				"discountingType=" + this.discountingType + ", " +
				"discountRateModel=" + this.discountRateModel +
			'}';
		}
	}
}
