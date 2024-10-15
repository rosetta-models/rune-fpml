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
import fpml.confirmation.CommodityBasketByNotional;
import fpml.confirmation.CommodityBasketByPercentage;
import fpml.confirmation.CommodityBasketModel;
import fpml.confirmation.CommodityBasketModel.CommodityBasketModelBuilder;
import fpml.confirmation.CommodityBasketModel.CommodityBasketModelBuilderImpl;
import fpml.confirmation.CommodityBasketModel.CommodityBasketModelImpl;
import fpml.confirmation.meta.CommodityBasketModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketModel", builder=CommodityBasketModel.CommodityBasketModelBuilderImpl.class, version="${project.version}")
public interface CommodityBasketModel extends RosettaModelObject {

	CommodityBasketModelMeta metaData = new CommodityBasketModelMeta();

	/*********************** Getter Methods  ***********************/
	CommodityBasketByNotional getNotionalQuantityBasket();
	CommodityBasketByPercentage getNotionalAmountBasket();

	/*********************** Build Methods  ***********************/
	CommodityBasketModel build();
	
	CommodityBasketModel.CommodityBasketModelBuilder toBuilder();
	
	static CommodityBasketModel.CommodityBasketModelBuilder builder() {
		return new CommodityBasketModel.CommodityBasketModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketModel> getType() {
		return CommodityBasketModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.class, getNotionalQuantityBasket());
		processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.class, getNotionalAmountBasket());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketModelBuilder extends CommodityBasketModel, RosettaModelObjectBuilder {
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket();
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket();
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket();
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket();
		CommodityBasketModel.CommodityBasketModelBuilder setNotionalQuantityBasket(CommodityBasketByNotional notionalQuantityBasket);
		CommodityBasketModel.CommodityBasketModelBuilder setNotionalAmountBasket(CommodityBasketByPercentage notionalAmountBasket);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.CommodityBasketByNotionalBuilder.class, getNotionalQuantityBasket());
			processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.CommodityBasketByPercentageBuilder.class, getNotionalAmountBasket());
		}
		

		CommodityBasketModel.CommodityBasketModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketModel  ***********************/
	class CommodityBasketModelImpl implements CommodityBasketModel {
		private final CommodityBasketByNotional notionalQuantityBasket;
		private final CommodityBasketByPercentage notionalAmountBasket;
		
		protected CommodityBasketModelImpl(CommodityBasketModel.CommodityBasketModelBuilder builder) {
			this.notionalQuantityBasket = ofNullable(builder.getNotionalQuantityBasket()).map(f->f.build()).orElse(null);
			this.notionalAmountBasket = ofNullable(builder.getNotionalAmountBasket()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		public CommodityBasketModel build() {
			return this;
		}
		
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder toBuilder() {
			CommodityBasketModel.CommodityBasketModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketModel.CommodityBasketModelBuilder builder) {
			ofNullable(getNotionalQuantityBasket()).ifPresent(builder::setNotionalQuantityBasket);
			ofNullable(getNotionalAmountBasket()).ifPresent(builder::setNotionalAmountBasket);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketModel {" +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasketModel  ***********************/
	class CommodityBasketModelBuilderImpl implements CommodityBasketModel.CommodityBasketModelBuilder {
	
		protected CommodityBasketByNotional.CommodityBasketByNotionalBuilder notionalQuantityBasket;
		protected CommodityBasketByPercentage.CommodityBasketByPercentageBuilder notionalAmountBasket;
	
		public CommodityBasketModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket() {
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder result;
			if (notionalQuantityBasket!=null) {
				result = notionalQuantityBasket;
			}
			else {
				result = notionalQuantityBasket = CommodityBasketByNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket() {
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder result;
			if (notionalAmountBasket!=null) {
				result = notionalAmountBasket;
			}
			else {
				result = notionalAmountBasket = CommodityBasketByPercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalQuantityBasket")
		public CommodityBasketModel.CommodityBasketModelBuilder setNotionalQuantityBasket(CommodityBasketByNotional notionalQuantityBasket) {
			this.notionalQuantityBasket = notionalQuantityBasket==null?null:notionalQuantityBasket.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmountBasket")
		public CommodityBasketModel.CommodityBasketModelBuilder setNotionalAmountBasket(CommodityBasketByPercentage notionalAmountBasket) {
			this.notionalAmountBasket = notionalAmountBasket==null?null:notionalAmountBasket.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketModel build() {
			return new CommodityBasketModel.CommodityBasketModelImpl(this);
		}
		
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder prune() {
			if (notionalQuantityBasket!=null && !notionalQuantityBasket.prune().hasData()) notionalQuantityBasket = null;
			if (notionalAmountBasket!=null && !notionalAmountBasket.prune().hasData()) notionalAmountBasket = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalQuantityBasket()!=null && getNotionalQuantityBasket().hasData()) return true;
			if (getNotionalAmountBasket()!=null && getNotionalAmountBasket().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketModel.CommodityBasketModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasketModel.CommodityBasketModelBuilder o = (CommodityBasketModel.CommodityBasketModelBuilder) other;
			
			merger.mergeRosetta(getNotionalQuantityBasket(), o.getNotionalQuantityBasket(), this::setNotionalQuantityBasket);
			merger.mergeRosetta(getNotionalAmountBasket(), o.getNotionalAmountBasket(), this::setNotionalAmountBasket);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketModelBuilder {" +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket +
			'}';
		}
	}
}
