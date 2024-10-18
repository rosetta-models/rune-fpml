package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityContentModel;
import fpml.confirmation.CommodityPerformanceSwapBase;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseImpl;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CommodityPerformanceSwapBaseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A product with which to represent return swaps, total return swaps and excess return swaps.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPerformanceSwapBase", builder=CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl.class, version="${project.version}")
public interface CommodityPerformanceSwapBase extends Product {

	CommodityPerformanceSwapBaseMeta metaData = new CommodityPerformanceSwapBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the Eeffective Date of the swap. It is an optional element because not all confirmations of total return swaps specify an Effective Date. In these cases the Term of the contract begins on the Trade Date.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the Termination Date of the swap.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 * The currency in which the commodity performance swap transaction will settle. It is an optional element because not all confirmations of performance swaps specify a Settlement Currency.
	 */
	IdentifiedCurrency getSettlementCurrency();
	List<? extends CommodityPerformanceSwapLeg> getCommodityPerformanceSwapLeg();
	CommodityContentModel getCommodityContentModel();

	/*********************** Build Methods  ***********************/
	CommodityPerformanceSwapBase build();
	
	CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder toBuilder();
	
	static CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder builder() {
		return new CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPerformanceSwapBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPerformanceSwapBase> getType() {
		return CommodityPerformanceSwapBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("commodityPerformanceSwapLeg"), processor, CommodityPerformanceSwapLeg.class, getCommodityPerformanceSwapLeg());
		processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.class, getCommodityContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPerformanceSwapBaseBuilder extends CommodityPerformanceSwapBase, Product.ProductBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency();
		CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder getOrCreateCommodityPerformanceSwapLeg(int _index);
		List<? extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder> getCommodityPerformanceSwapLeg();
		CommodityContentModel.CommodityContentModelBuilder getOrCreateCommodityContentModel();
		CommodityContentModel.CommodityContentModelBuilder getCommodityContentModel();
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setProductModel(ProductModel productModel);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setId(String id);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg0);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg1, int _idx);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg2);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg3);
		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("commodityPerformanceSwapLeg"), processor, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder.class, getCommodityPerformanceSwapLeg());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
		}
		

		CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPerformanceSwapBase  ***********************/
	class CommodityPerformanceSwapBaseImpl extends Product.ProductImpl implements CommodityPerformanceSwapBase {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final IdentifiedCurrency settlementCurrency;
		private final List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg;
		private final CommodityContentModel commodityContentModel;
		
		protected CommodityPerformanceSwapBaseImpl(CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder builder) {
			super(builder);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.commodityPerformanceSwapLeg = ofNullable(builder.getCommodityPerformanceSwapLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityContentModel = ofNullable(builder.getCommodityContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("commodityPerformanceSwapLeg")
		public List<? extends CommodityPerformanceSwapLeg> getCommodityPerformanceSwapLeg() {
			return commodityPerformanceSwapLeg;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityContentModel getCommodityContentModel() {
			return commodityContentModel;
		}
		
		@Override
		public CommodityPerformanceSwapBase build() {
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder toBuilder() {
			CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getCommodityPerformanceSwapLeg()).ifPresent(builder::setCommodityPerformanceSwapLeg);
			ofNullable(getCommodityContentModel()).ifPresent(builder::setCommodityContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commodityPerformanceSwapLeg, _that.getCommodityPerformanceSwapLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commodityPerformanceSwapLeg != null ? commodityPerformanceSwapLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapBase {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commodityPerformanceSwapLeg=" + this.commodityPerformanceSwapLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPerformanceSwapBase  ***********************/
	class CommodityPerformanceSwapBaseBuilderImpl extends Product.ProductBuilderImpl  implements CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder settlementCurrency;
		protected List<CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder> commodityPerformanceSwapLeg = new ArrayList<>();
		protected CommodityContentModel.CommodityContentModelBuilder commodityContentModel;
	
		public CommodityPerformanceSwapBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateSettlementCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPerformanceSwapLeg")
		public List<? extends CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder> getCommodityPerformanceSwapLeg() {
			return commodityPerformanceSwapLeg;
		}
		
		@Override
		public CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder getOrCreateCommodityPerformanceSwapLeg(int _index) {
		
			if (commodityPerformanceSwapLeg==null) {
				this.commodityPerformanceSwapLeg = new ArrayList<>();
			}
			CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder result;
			return getIndex(commodityPerformanceSwapLeg, _index, () -> {
						CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder newCommodityPerformanceSwapLeg = CommodityPerformanceSwapLeg.builder();
						return newCommodityPerformanceSwapLeg;
					});
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
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPerformanceSwapLeg")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg) {
			if (commodityPerformanceSwapLeg!=null) this.commodityPerformanceSwapLeg.add(commodityPerformanceSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg, int _idx) {
			getIndex(this.commodityPerformanceSwapLeg, _idx, () -> commodityPerformanceSwapLeg.toBuilder());
			return this;
		}
		@Override 
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
			if (commodityPerformanceSwapLegs != null) {
				for (CommodityPerformanceSwapLeg toAdd : commodityPerformanceSwapLegs) {
					this.commodityPerformanceSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
			if (commodityPerformanceSwapLegs == null)  {
				this.commodityPerformanceSwapLeg = new ArrayList<>();
			}
			else {
				this.commodityPerformanceSwapLeg = commodityPerformanceSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityContentModel")
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPerformanceSwapBase build() {
			return new CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseImpl(this);
		}
		
		@Override
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			commodityPerformanceSwapLeg = commodityPerformanceSwapLeg.stream().filter(b->b!=null).<CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityContentModel!=null && !commodityContentModel.prune().hasData()) commodityContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getCommodityPerformanceSwapLeg()!=null && getCommodityPerformanceSwapLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityContentModel()!=null && getCommodityContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder o = (CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getCommodityPerformanceSwapLeg(), o.getCommodityPerformanceSwapLeg(), this::getOrCreateCommodityPerformanceSwapLeg);
			merger.mergeRosetta(getCommodityContentModel(), o.getCommodityContentModel(), this::setCommodityContentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwapBase _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!ListEquals.listEquals(commodityPerformanceSwapLeg, _that.getCommodityPerformanceSwapLeg())) return false;
			if (!Objects.equals(commodityContentModel, _that.getCommodityContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (commodityPerformanceSwapLeg != null ? commodityPerformanceSwapLeg.hashCode() : 0);
			_result = 31 * _result + (commodityContentModel != null ? commodityContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapBaseBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"commodityPerformanceSwapLeg=" + this.commodityPerformanceSwapLeg + ", " +
				"commodityContentModel=" + this.commodityContentModel +
			'}' + " " + super.toString();
		}
	}
}
