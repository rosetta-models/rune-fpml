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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AveragePriceLeg;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityForward;
import fpml.confirmation.CommodityForward.CommodityForwardBuilder;
import fpml.confirmation.CommodityForward.CommodityForwardBuilderImpl;
import fpml.confirmation.CommodityForward.CommodityForwardImpl;
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.NonPeriodicFixedPriceLeg;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CommodityForwardMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a commodity forward product. Commodity Forward
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityForward", builder=CommodityForward.CommodityForwardBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityForward extends Product {

	CommodityForwardMeta metaData = new CommodityForwardMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the value date of the Commodity Forward Transaction. This is the day on which both the cash and the physical commodity settle.
	 */
	AdjustableOrRelativeDate getValueDate();
	/**
	 * The fixed leg of a Commodity Forward Transaction.
	 */
	NonPeriodicFixedPriceLeg getFixedLeg();
	/**
	 * Specifies the calculated floating price leg of a Commodity Forward Transaction.
	 */
	AveragePriceLeg getAveragePriceLeg();
	CommodityForwardLeg getCommodityForwardLeg();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommodityForward build();
	
	CommodityForward.CommodityForwardBuilder toBuilder();
	
	static CommodityForward.CommodityForwardBuilder builder() {
		return new CommodityForward.CommodityForwardBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityForward> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityForward> getType() {
		return CommodityForward.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("valueDate"), processor, AdjustableOrRelativeDate.class, getValueDate());
		processRosetta(path.newSubPath("fixedLeg"), processor, NonPeriodicFixedPriceLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("averagePriceLeg"), processor, AveragePriceLeg.class, getAveragePriceLeg());
		processRosetta(path.newSubPath("commodityForwardLeg"), processor, CommodityForwardLeg.class, getCommodityForwardLeg());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityForwardBuilder extends CommodityForward, Product.ProductBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValueDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValueDate();
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getOrCreateFixedLeg();
		NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getFixedLeg();
		AveragePriceLeg.AveragePriceLegBuilder getOrCreateAveragePriceLeg();
		AveragePriceLeg.AveragePriceLegBuilder getAveragePriceLeg();
		CommodityForwardLeg.CommodityForwardLegBuilder getOrCreateCommodityForwardLeg();
		CommodityForwardLeg.CommodityForwardLegBuilder getCommodityForwardLeg();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommodityForward.CommodityForwardBuilder setProductModel(ProductModel productModel);
		CommodityForward.CommodityForwardBuilder setId(String id);
		CommodityForward.CommodityForwardBuilder setValueDate(AdjustableOrRelativeDate valueDate);
		CommodityForward.CommodityForwardBuilder setFixedLeg(NonPeriodicFixedPriceLeg fixedLeg);
		CommodityForward.CommodityForwardBuilder setAveragePriceLeg(AveragePriceLeg averagePriceLeg);
		CommodityForward.CommodityForwardBuilder setCommodityForwardLeg(CommodityForwardLeg commodityForwardLeg);
		CommodityForward.CommodityForwardBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("valueDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getValueDate());
			processRosetta(path.newSubPath("fixedLeg"), processor, NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("averagePriceLeg"), processor, AveragePriceLeg.AveragePriceLegBuilder.class, getAveragePriceLeg());
			processRosetta(path.newSubPath("commodityForwardLeg"), processor, CommodityForwardLeg.CommodityForwardLegBuilder.class, getCommodityForwardLeg());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommodityForward.CommodityForwardBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityForward  ***********************/
	class CommodityForwardImpl extends Product.ProductImpl implements CommodityForward {
		private final AdjustableOrRelativeDate valueDate;
		private final NonPeriodicFixedPriceLeg fixedLeg;
		private final AveragePriceLeg averagePriceLeg;
		private final CommodityForwardLeg commodityForwardLeg;
		private final CommodityContentModel commodityContentModel;
		
		protected CommodityForwardImpl(CommodityForward.CommodityForwardBuilder builder) {
			super(builder);
			this.valueDate = ofNullable(builder.getValueDate()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.averagePriceLeg = ofNullable(builder.getAveragePriceLeg()).map(f->f.build()).orElse(null);
			this.commodityForwardLeg = ofNullable(builder.getCommodityForwardLeg()).map(f->f.build()).orElse(null);
			this.commodityContentModel = ofNullable(builder.getCommodityContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valueDate")
		public AdjustableOrRelativeDate getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public NonPeriodicFixedPriceLeg getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		@RosettaAttribute("averagePriceLeg")
		public AveragePriceLeg getAveragePriceLeg() {
			return averagePriceLeg;
		}
		
		@Override
		@RosettaAttribute("commodityForwardLeg")
		public CommodityForwardLeg getCommodityForwardLeg() {
			return commodityForwardLeg;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityForward build() {
			return this;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder toBuilder() {
			CommodityForward.CommodityForwardBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityForward.CommodityForwardBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
			ofNullable(getAveragePriceLeg()).ifPresent(builder::setAveragePriceLeg);
			ofNullable(getCommodityForwardLeg()).ifPresent(builder::setCommodityForwardLeg);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityForward _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(averagePriceLeg, _that.getAveragePriceLeg())) return false;
			if (!Objects.equals(commodityForwardLeg, _that.getCommodityForwardLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (averagePriceLeg != null ? averagePriceLeg.hashCode() : 0);
			_result = 31 * _result + (commodityForwardLeg != null ? commodityForwardLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityForward {" +
				"valueDate=" + this.valueDate + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"averagePriceLeg=" + this.averagePriceLeg + ", " +
				"commodityForwardLeg=" + this.commodityForwardLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityForward  ***********************/
	class CommodityForwardBuilderImpl extends Product.ProductBuilderImpl  implements CommodityForward.CommodityForwardBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder valueDate;
		protected NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder fixedLeg;
		protected AveragePriceLeg.AveragePriceLegBuilder averagePriceLeg;
		protected CommodityForwardLeg.CommodityForwardLegBuilder commodityForwardLeg;
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommodityForwardBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valueDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getValueDate() {
			return valueDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateValueDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (valueDate!=null) {
				result = valueDate;
			}
			else {
				result = valueDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder getOrCreateFixedLeg() {
			NonPeriodicFixedPriceLeg.NonPeriodicFixedPriceLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = NonPeriodicFixedPriceLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagePriceLeg")
		public AveragePriceLeg.AveragePriceLegBuilder getAveragePriceLeg() {
			return averagePriceLeg;
		}
		
		@Override
		public AveragePriceLeg.AveragePriceLegBuilder getOrCreateAveragePriceLeg() {
			AveragePriceLeg.AveragePriceLegBuilder result;
			if (averagePriceLeg!=null) {
				result = averagePriceLeg;
			}
			else {
				result = averagePriceLeg = AveragePriceLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityForwardLeg")
		public CommodityForwardLeg.CommodityForwardLegBuilder getCommodityForwardLeg() {
			return commodityForwardLeg;
		}
		
		@Override
		public CommodityForwardLeg.CommodityForwardLegBuilder getOrCreateCommodityForwardLeg() {
			CommodityForwardLeg.CommodityForwardLegBuilder result;
			if (commodityForwardLeg!=null) {
				result = commodityForwardLeg;
			}
			else {
				result = commodityForwardLeg = CommodityForwardLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel() {
			CommodityContentModel.CommodityContentModelBuilder result;
			if (commodityContentModel!=null) {
				result = commodityContentModel;
			}
			else {
				result = commodityContentModel = CommodityContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CommodityForward.CommodityForwardBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityForward.CommodityForwardBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("valueDate")
		public CommodityForward.CommodityForwardBuilder setValueDate(AdjustableOrRelativeDate valueDate) {
			this.valueDate = valueDate==null?null:valueDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedLeg")
		public CommodityForward.CommodityForwardBuilder setFixedLeg(NonPeriodicFixedPriceLeg fixedLeg) {
			this.fixedLeg = fixedLeg==null?null:fixedLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagePriceLeg")
		public CommodityForward.CommodityForwardBuilder setAveragePriceLeg(AveragePriceLeg averagePriceLeg) {
			this.averagePriceLeg = averagePriceLeg==null?null:averagePriceLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityForwardLeg")
		public CommodityForward.CommodityForwardBuilder setCommodityForwardLeg(CommodityForwardLeg commodityForwardLeg) {
			this.commodityForwardLeg = commodityForwardLeg==null?null:commodityForwardLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityForward.CommodityForwardBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityForward build() {
			return new CommodityForward.CommodityForwardImpl(this);
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityForward.CommodityForwardBuilder prune() {
			super.prune();
			if (valueDate!=null && !valueDate.prune().hasData()) valueDate = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (averagePriceLeg!=null && !averagePriceLeg.prune().hasData()) averagePriceLeg = null;
			if (commodityForwardLeg!=null && !commodityForwardLeg.prune().hasData()) commodityForwardLeg = null;
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValueDate()!=null && getValueDate().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getAveragePriceLeg()!=null && getAveragePriceLeg().hasData()) return true;
			if (getCommodityForwardLeg()!=null && getCommodityForwardLeg().hasData()) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityForward.CommodityForwardBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityForward.CommodityForwardBuilder o = (CommodityForward.CommodityForwardBuilder) other;
			
			merger.mergeRosetta(getValueDate(), o.getValueDate(), this::setValueDate);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
			merger.mergeRosetta(getAveragePriceLeg(), o.getAveragePriceLeg(), this::setAveragePriceLeg);
			merger.mergeRosetta(getCommodityForwardLeg(), o.getCommodityForwardLeg(), this::setCommodityForwardLeg);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityForward _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(averagePriceLeg, _that.getAveragePriceLeg())) return false;
			if (!Objects.equals(commodityForwardLeg, _that.getCommodityForwardLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (averagePriceLeg != null ? averagePriceLeg.hashCode() : 0);
			_result = 31 * _result + (commodityForwardLeg != null ? commodityForwardLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityForwardBuilder {" +
				"valueDate=" + this.valueDate + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"averagePriceLeg=" + this.averagePriceLeg + ", " +
				"commodityForwardLeg=" + this.commodityForwardLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
