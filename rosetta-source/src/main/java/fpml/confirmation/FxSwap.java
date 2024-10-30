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
import fpml.confirmation.FxSwap;
import fpml.confirmation.FxSwap.FxSwapBuilder;
import fpml.confirmation.FxSwap.FxSwapBuilderImpl;
import fpml.confirmation.FxSwap.FxSwapImpl;
import fpml.confirmation.FxSwapLeg;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.FxSwapMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An FX Swap transaction definition. A type defining either a spot/forward or forward/forward FX swap transaction.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxSwap", builder=FxSwap.FxSwapBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxSwap extends Product {

	FxSwapMeta metaData = new FxSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The FX transaction with the earliest value date.
	 */
	FxSwapLeg getNearLeg();
	/**
	 * The FX transaction with the latest value date.
	 */
	FxSwapLeg getFarLeg();

	/*********************** Build Methods  ***********************/
	FxSwap build();
	
	FxSwap.FxSwapBuilder toBuilder();
	
	static FxSwap.FxSwapBuilder builder() {
		return new FxSwap.FxSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSwap> getType() {
		return FxSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("nearLeg"), processor, FxSwapLeg.class, getNearLeg());
		processRosetta(path.newSubPath("farLeg"), processor, FxSwapLeg.class, getFarLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSwapBuilder extends FxSwap, Product.ProductBuilder {
		FxSwapLeg.FxSwapLegBuilder getOrCreateNearLeg();
		FxSwapLeg.FxSwapLegBuilder getNearLeg();
		FxSwapLeg.FxSwapLegBuilder getOrCreateFarLeg();
		FxSwapLeg.FxSwapLegBuilder getFarLeg();
		FxSwap.FxSwapBuilder setProductModel(ProductModel productModel);
		FxSwap.FxSwapBuilder setId(String id);
		FxSwap.FxSwapBuilder setNearLeg(FxSwapLeg nearLeg);
		FxSwap.FxSwapBuilder setFarLeg(FxSwapLeg farLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("nearLeg"), processor, FxSwapLeg.FxSwapLegBuilder.class, getNearLeg());
			processRosetta(path.newSubPath("farLeg"), processor, FxSwapLeg.FxSwapLegBuilder.class, getFarLeg());
		}
		

		FxSwap.FxSwapBuilder prune();
	}

	/*********************** Immutable Implementation of FxSwap  ***********************/
	class FxSwapImpl extends Product.ProductImpl implements FxSwap {
		private final FxSwapLeg nearLeg;
		private final FxSwapLeg farLeg;
		
		protected FxSwapImpl(FxSwap.FxSwapBuilder builder) {
			super(builder);
			this.nearLeg = ofNullable(builder.getNearLeg()).map(f->f.build()).orElse(null);
			this.farLeg = ofNullable(builder.getFarLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("nearLeg")
		public FxSwapLeg getNearLeg() {
			return nearLeg;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		public FxSwapLeg getFarLeg() {
			return farLeg;
		}
		
		@Override
		public FxSwap build() {
			return this;
		}
		
		@Override
		public FxSwap.FxSwapBuilder toBuilder() {
			FxSwap.FxSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSwap.FxSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getNearLeg()).ifPresent(builder::setNearLeg);
			ofNullable(getFarLeg()).ifPresent(builder::setFarLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwap _that = getType().cast(o);
		
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwap {" +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxSwap  ***********************/
	class FxSwapBuilderImpl extends Product.ProductBuilderImpl  implements FxSwap.FxSwapBuilder {
	
		protected FxSwapLeg.FxSwapLegBuilder nearLeg;
		protected FxSwapLeg.FxSwapLegBuilder farLeg;
	
		public FxSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("nearLeg")
		public FxSwapLeg.FxSwapLegBuilder getNearLeg() {
			return nearLeg;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder getOrCreateNearLeg() {
			FxSwapLeg.FxSwapLegBuilder result;
			if (nearLeg!=null) {
				result = nearLeg;
			}
			else {
				result = nearLeg = FxSwapLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("farLeg")
		public FxSwapLeg.FxSwapLegBuilder getFarLeg() {
			return farLeg;
		}
		
		@Override
		public FxSwapLeg.FxSwapLegBuilder getOrCreateFarLeg() {
			FxSwapLeg.FxSwapLegBuilder result;
			if (farLeg!=null) {
				result = farLeg;
			}
			else {
				result = farLeg = FxSwapLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public FxSwap.FxSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxSwap.FxSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("nearLeg")
		public FxSwap.FxSwapBuilder setNearLeg(FxSwapLeg nearLeg) {
			this.nearLeg = nearLeg==null?null:nearLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("farLeg")
		public FxSwap.FxSwapBuilder setFarLeg(FxSwapLeg farLeg) {
			this.farLeg = farLeg==null?null:farLeg.toBuilder();
			return this;
		}
		
		@Override
		public FxSwap build() {
			return new FxSwap.FxSwapImpl(this);
		}
		
		@Override
		public FxSwap.FxSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwap.FxSwapBuilder prune() {
			super.prune();
			if (nearLeg!=null && !nearLeg.prune().hasData()) nearLeg = null;
			if (farLeg!=null && !farLeg.prune().hasData()) farLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getNearLeg()!=null && getNearLeg().hasData()) return true;
			if (getFarLeg()!=null && getFarLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSwap.FxSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxSwap.FxSwapBuilder o = (FxSwap.FxSwapBuilder) other;
			
			merger.mergeRosetta(getNearLeg(), o.getNearLeg(), this::setNearLeg);
			merger.mergeRosetta(getFarLeg(), o.getFarLeg(), this::setFarLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxSwap _that = getType().cast(o);
		
			if (!Objects.equals(nearLeg, _that.getNearLeg())) return false;
			if (!Objects.equals(farLeg, _that.getFarLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (nearLeg != null ? nearLeg.hashCode() : 0);
			_result = 31 * _result + (farLeg != null ? farLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSwapBuilder {" +
				"nearLeg=" + this.nearLeg + ", " +
				"farLeg=" + this.farLeg +
			'}' + " " + super.toString();
		}
	}
}
