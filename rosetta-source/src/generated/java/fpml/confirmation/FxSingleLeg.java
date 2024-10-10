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
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.FxSingleLeg;
import fpml.confirmation.FxSingleLeg.FxSingleLegBuilder;
import fpml.confirmation.FxSingleLeg.FxSingleLegBuilderImpl;
import fpml.confirmation.FxSingleLeg.FxSingleLegImpl;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.FxSingleLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A simple FX spot or forward transaction definition. A type defining either a spot or forward FX transactions.
 * @version ${project.version}
 */
@RosettaDataType(value="FxSingleLeg", builder=FxSingleLeg.FxSingleLegBuilderImpl.class, version="${project.version}")
public interface FxSingleLeg extends Product {

	FxSingleLegMeta metaData = new FxSingleLegMeta();

	/*********************** Getter Methods  ***********************/
	FxCoreDetailsModel getFxCoreDetailsModel();

	/*********************** Build Methods  ***********************/
	FxSingleLeg build();
	
	FxSingleLeg.FxSingleLegBuilder toBuilder();
	
	static FxSingleLeg.FxSingleLegBuilder builder() {
		return new FxSingleLeg.FxSingleLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSingleLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSingleLeg> getType() {
		return FxSingleLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fxCoreDetailsModel"), processor, FxCoreDetailsModel.class, getFxCoreDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSingleLegBuilder extends FxSingleLeg, Product.ProductBuilder {
		FxCoreDetailsModel.FxCoreDetailsModelBuilder getOrCreateFxCoreDetailsModel();
		FxCoreDetailsModel.FxCoreDetailsModelBuilder getFxCoreDetailsModel();
		FxSingleLeg.FxSingleLegBuilder setProductModel(ProductModel productModel);
		FxSingleLeg.FxSingleLegBuilder setId(String id);
		FxSingleLeg.FxSingleLegBuilder setFxCoreDetailsModel(FxCoreDetailsModel fxCoreDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fxCoreDetailsModel"), processor, FxCoreDetailsModel.FxCoreDetailsModelBuilder.class, getFxCoreDetailsModel());
		}
		

		FxSingleLeg.FxSingleLegBuilder prune();
	}

	/*********************** Immutable Implementation of FxSingleLeg  ***********************/
	class FxSingleLegImpl extends Product.ProductImpl implements FxSingleLeg {
		private final FxCoreDetailsModel fxCoreDetailsModel;
		
		protected FxSingleLegImpl(FxSingleLeg.FxSingleLegBuilder builder) {
			super(builder);
			this.fxCoreDetailsModel = ofNullable(builder.getFxCoreDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxCoreDetailsModel getFxCoreDetailsModel() {
			return fxCoreDetailsModel;
		}
		
		@Override
		public FxSingleLeg build() {
			return this;
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder toBuilder() {
			FxSingleLeg.FxSingleLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSingleLeg.FxSingleLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFxCoreDetailsModel()).ifPresent(builder::setFxCoreDetailsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSingleLeg _that = getType().cast(o);
		
			if (!Objects.equals(fxCoreDetailsModel, _that.getFxCoreDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxCoreDetailsModel != null ? fxCoreDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSingleLeg {" +
				"fxCoreDetailsModel=" + this.fxCoreDetailsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSingleLeg  ***********************/
	class FxSingleLegBuilderImpl extends Product.ProductBuilderImpl  implements FxSingleLeg.FxSingleLegBuilder {
	
		protected FxCoreDetailsModel.FxCoreDetailsModelBuilder fxCoreDetailsModel;
	
		public FxSingleLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder getFxCoreDetailsModel() {
			return fxCoreDetailsModel;
		}
		
		@Override
		public FxCoreDetailsModel.FxCoreDetailsModelBuilder getOrCreateFxCoreDetailsModel() {
			FxCoreDetailsModel.FxCoreDetailsModelBuilder result;
			if (fxCoreDetailsModel!=null) {
				result = fxCoreDetailsModel;
			}
			else {
				result = fxCoreDetailsModel = FxCoreDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxSingleLeg.FxSingleLegBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxSingleLeg.FxSingleLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fxCoreDetailsModel")
		public FxSingleLeg.FxSingleLegBuilder setFxCoreDetailsModel(FxCoreDetailsModel fxCoreDetailsModel) {
			this.fxCoreDetailsModel = fxCoreDetailsModel==null?null:fxCoreDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public FxSingleLeg build() {
			return new FxSingleLeg.FxSingleLegImpl(this);
		}
		
		@Override
		public FxSingleLeg.FxSingleLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSingleLeg.FxSingleLegBuilder prune() {
			super.prune();
			if (fxCoreDetailsModel!=null && !fxCoreDetailsModel.prune().hasData()) fxCoreDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFxCoreDetailsModel()!=null && getFxCoreDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSingleLeg.FxSingleLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxSingleLeg.FxSingleLegBuilder o = (FxSingleLeg.FxSingleLegBuilder) other;
			
			merger.mergeRosetta(getFxCoreDetailsModel(), o.getFxCoreDetailsModel(), this::setFxCoreDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSingleLeg _that = getType().cast(o);
		
			if (!Objects.equals(fxCoreDetailsModel, _that.getFxCoreDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxCoreDetailsModel != null ? fxCoreDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSingleLegBuilder {" +
				"fxCoreDetailsModel=" + this.fxCoreDetailsModel +
			'}' + " " + super.toString();
		}
	}
}
