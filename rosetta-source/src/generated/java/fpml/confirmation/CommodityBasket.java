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
import fpml.confirmation.BasketIdentifierModel;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityBasket.CommodityBasketBuilder;
import fpml.confirmation.CommodityBasket.CommodityBasketBuilderImpl;
import fpml.confirmation.CommodityBasket.CommodityBasketImpl;
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.meta.CommodityBasketMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the swap&#39;s underlyer when it has multiple asset components.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasket", builder=CommodityBasket.CommodityBasketBuilderImpl.class, version="${project.version}")
public interface CommodityBasket extends RosettaModelObject {

	CommodityBasketMeta metaData = new CommodityBasketMeta();

	/*********************** Getter Methods  ***********************/
	BasketIdentifierModel getBasketIdentifierModel();
	CommodityBasketModel getCommodityBasketModel();

	/*********************** Build Methods  ***********************/
	CommodityBasket build();
	
	CommodityBasket.CommodityBasketBuilder toBuilder();
	
	static CommodityBasket.CommodityBasketBuilder builder() {
		return new CommodityBasket.CommodityBasketBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasket> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasket> getType() {
		return CommodityBasket.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.class, getBasketIdentifierModel());
		processRosetta(path.newSubPath("commodityBasketModel"), processor, CommodityBasketModel.class, getCommodityBasketModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketBuilder extends CommodityBasket, RosettaModelObjectBuilder {
		BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel();
		BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel();
		CommodityBasketModel.CommodityBasketModelBuilder getOrCreateCommodityBasketModel();
		CommodityBasketModel.CommodityBasketModelBuilder getCommodityBasketModel();
		CommodityBasket.CommodityBasketBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel);
		CommodityBasket.CommodityBasketBuilder setCommodityBasketModel(CommodityBasketModel commodityBasketModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("basketIdentifierModel"), processor, BasketIdentifierModel.BasketIdentifierModelBuilder.class, getBasketIdentifierModel());
			processRosetta(path.newSubPath("commodityBasketModel"), processor, CommodityBasketModel.CommodityBasketModelBuilder.class, getCommodityBasketModel());
		}
		

		CommodityBasket.CommodityBasketBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasket  ***********************/
	class CommodityBasketImpl implements CommodityBasket {
		private final BasketIdentifierModel basketIdentifierModel;
		private final CommodityBasketModel commodityBasketModel;
		
		protected CommodityBasketImpl(CommodityBasket.CommodityBasketBuilder builder) {
			this.basketIdentifierModel = ofNullable(builder.getBasketIdentifierModel()).map(f->f.build()).orElse(null);
			this.commodityBasketModel = ofNullable(builder.getCommodityBasketModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasketModel getCommodityBasketModel() {
			return commodityBasketModel;
		}
		
		@Override
		public CommodityBasket build() {
			return this;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder toBuilder() {
			CommodityBasket.CommodityBasketBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasket.CommodityBasketBuilder builder) {
			ofNullable(getBasketIdentifierModel()).ifPresent(builder::setBasketIdentifierModel);
			ofNullable(getCommodityBasketModel()).ifPresent(builder::setCommodityBasketModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(commodityBasketModel, _that.getCommodityBasketModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (commodityBasketModel != null ? commodityBasketModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasket {" +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"commodityBasketModel=" + this.commodityBasketModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasket  ***********************/
	class CommodityBasketBuilderImpl implements CommodityBasket.CommodityBasketBuilder {
	
		protected BasketIdentifierModel.BasketIdentifierModelBuilder basketIdentifierModel;
		protected CommodityBasketModel.CommodityBasketModelBuilder commodityBasketModel;
	
		public CommodityBasketBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public BasketIdentifierModel.BasketIdentifierModelBuilder getBasketIdentifierModel() {
			return basketIdentifierModel;
		}
		
		@Override
		public BasketIdentifierModel.BasketIdentifierModelBuilder getOrCreateBasketIdentifierModel() {
			BasketIdentifierModel.BasketIdentifierModelBuilder result;
			if (basketIdentifierModel!=null) {
				result = basketIdentifierModel;
			}
			else {
				result = basketIdentifierModel = BasketIdentifierModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasketModel.CommodityBasketModelBuilder getCommodityBasketModel() {
			return commodityBasketModel;
		}
		
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder getOrCreateCommodityBasketModel() {
			CommodityBasketModel.CommodityBasketModelBuilder result;
			if (commodityBasketModel!=null) {
				result = commodityBasketModel;
			}
			else {
				result = commodityBasketModel = CommodityBasketModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketIdentifierModel")
		public CommodityBasket.CommodityBasketBuilder setBasketIdentifierModel(BasketIdentifierModel basketIdentifierModel) {
			this.basketIdentifierModel = basketIdentifierModel==null?null:basketIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityBasketModel")
		public CommodityBasket.CommodityBasketBuilder setCommodityBasketModel(CommodityBasketModel commodityBasketModel) {
			this.commodityBasketModel = commodityBasketModel==null?null:commodityBasketModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasket build() {
			return new CommodityBasket.CommodityBasketImpl(this);
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasket.CommodityBasketBuilder prune() {
			if (basketIdentifierModel!=null && !basketIdentifierModel.prune().hasData()) basketIdentifierModel = null;
			if (commodityBasketModel!=null && !commodityBasketModel.prune().hasData()) commodityBasketModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasketIdentifierModel()!=null && getBasketIdentifierModel().hasData()) return true;
			if (getCommodityBasketModel()!=null && getCommodityBasketModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasket.CommodityBasketBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasket.CommodityBasketBuilder o = (CommodityBasket.CommodityBasketBuilder) other;
			
			merger.mergeRosetta(getBasketIdentifierModel(), o.getBasketIdentifierModel(), this::setBasketIdentifierModel);
			merger.mergeRosetta(getCommodityBasketModel(), o.getCommodityBasketModel(), this::setCommodityBasketModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasket _that = getType().cast(o);
		
			if (!Objects.equals(basketIdentifierModel, _that.getBasketIdentifierModel())) return false;
			if (!Objects.equals(commodityBasketModel, _that.getCommodityBasketModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basketIdentifierModel != null ? basketIdentifierModel.hashCode() : 0);
			_result = 31 * _result + (commodityBasketModel != null ? commodityBasketModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketBuilder {" +
				"basketIdentifierModel=" + this.basketIdentifierModel + ", " +
				"commodityBasketModel=" + this.commodityBasketModel +
			'}';
		}
	}
}
