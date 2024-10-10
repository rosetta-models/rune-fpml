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
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasket;
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import fpml.confirmation.CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder;
import fpml.confirmation.CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilderImpl;
import fpml.confirmation.CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelImpl;
import fpml.confirmation.meta.CommodityUnderlyerChoiceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the type of underlyer: a single commodity or a basket of commodities.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityUnderlyerChoiceModel", builder=CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilderImpl.class, version="${project.version}")
public interface CommodityUnderlyerChoiceModel extends RosettaModelObject {

	CommodityUnderlyerChoiceModelMeta metaData = new CommodityUnderlyerChoiceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the swap&#39;s underlyer when it has only one asset component.
	 */
	Commodity getCommodity();
	/**
	 * Describes the swap&#39;s underlyer when it has multiple asset components.
	 */
	CommodityBasket getCommodityBasket();

	/*********************** Build Methods  ***********************/
	CommodityUnderlyerChoiceModel build();
	
	CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder toBuilder();
	
	static CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder builder() {
		return new CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityUnderlyerChoiceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityUnderlyerChoiceModel> getType() {
		return CommodityUnderlyerChoiceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("commodityBasket"), processor, CommodityBasket.class, getCommodityBasket());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityUnderlyerChoiceModelBuilder extends CommodityUnderlyerChoiceModel, RosettaModelObjectBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		Commodity.CommodityBuilder getCommodity();
		CommodityBasket.CommodityBasketBuilder getOrCreateCommodityBasket();
		CommodityBasket.CommodityBasketBuilder getCommodityBasket();
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder setCommodity(Commodity commodity);
		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder setCommodityBasket(CommodityBasket commodityBasket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("commodityBasket"), processor, CommodityBasket.CommodityBasketBuilder.class, getCommodityBasket());
		}
		

		CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityUnderlyerChoiceModel  ***********************/
	class CommodityUnderlyerChoiceModelImpl implements CommodityUnderlyerChoiceModel {
		private final Commodity commodity;
		private final CommodityBasket commodityBasket;
		
		protected CommodityUnderlyerChoiceModelImpl(CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder builder) {
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.commodityBasket = ofNullable(builder.getCommodityBasket()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("commodityBasket")
		public CommodityBasket getCommodityBasket() {
			return commodityBasket;
		}
		
		@Override
		public CommodityUnderlyerChoiceModel build() {
			return this;
		}
		
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder toBuilder() {
			CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder builder) {
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getCommodityBasket()).ifPresent(builder::setCommodityBasket);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUnderlyerChoiceModel _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityBasket, _that.getCommodityBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityBasket != null ? commodityBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUnderlyerChoiceModel {" +
				"commodity=" + this.commodity + ", " +
				"commodityBasket=" + this.commodityBasket +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityUnderlyerChoiceModel  ***********************/
	class CommodityUnderlyerChoiceModelBuilderImpl implements CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder {
	
		protected Commodity.CommodityBuilder commodity;
		protected CommodityBasket.CommodityBasketBuilder commodityBasket;
	
		public CommodityUnderlyerChoiceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityBasket")
		public CommodityBasket.CommodityBasketBuilder getCommodityBasket() {
			return commodityBasket;
		}
		
		@Override
		public CommodityBasket.CommodityBasketBuilder getOrCreateCommodityBasket() {
			CommodityBasket.CommodityBasketBuilder result;
			if (commodityBasket!=null) {
				result = commodityBasket;
			}
			else {
				result = commodityBasket = CommodityBasket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodity")
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityBasket")
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder setCommodityBasket(CommodityBasket commodityBasket) {
			this.commodityBasket = commodityBasket==null?null:commodityBasket.toBuilder();
			return this;
		}
		
		@Override
		public CommodityUnderlyerChoiceModel build() {
			return new CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelImpl(this);
		}
		
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder prune() {
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (commodityBasket!=null && !commodityBasket.prune().hasData()) commodityBasket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getCommodityBasket()!=null && getCommodityBasket().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder o = (CommodityUnderlyerChoiceModel.CommodityUnderlyerChoiceModelBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getCommodityBasket(), o.getCommodityBasket(), this::setCommodityBasket);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityUnderlyerChoiceModel _that = getType().cast(o);
		
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(commodityBasket, _that.getCommodityBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (commodityBasket != null ? commodityBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityUnderlyerChoiceModelBuilder {" +
				"commodity=" + this.commodity + ", " +
				"commodityBasket=" + this.commodityBasket +
			'}';
		}
	}
}
