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
import fpml.confirmation.CommodityPerformanceSwap;
import fpml.confirmation.CommodityPerformanceSwap.CommodityPerformanceSwapBuilder;
import fpml.confirmation.CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwap.CommodityPerformanceSwapImpl;
import fpml.confirmation.CommodityPerformanceSwapBase;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl;
import fpml.confirmation.CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseImpl;
import fpml.confirmation.CommodityPerformanceSwapEarlyTermination;
import fpml.confirmation.CommodityPerformanceSwapLeg;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CommodityPerformanceSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A swap the payoff of which is linked to the performance of the underlying asset. Examples of potential performance features are return, correlation, covariance, variance and volatility. A type describing a commodity performance swap in which one leg pays out based on the return on a reference commodity index or commodity reference price.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPerformanceSwap", builder=CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl.class, version="${project.version}")
public interface CommodityPerformanceSwap extends CommodityPerformanceSwapBase {

	CommodityPerformanceSwapMeta metaData = new CommodityPerformanceSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies, for one or for both the parties to the trade, the date prior to the Termination Date from which the contract can be terminated.
	 */
	List<? extends CommodityPerformanceSwapEarlyTermination> getEarlyTermination();

	/*********************** Build Methods  ***********************/
	CommodityPerformanceSwap build();
	
	CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder();
	
	static CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder() {
		return new CommodityPerformanceSwap.CommodityPerformanceSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPerformanceSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPerformanceSwap> getType() {
		return CommodityPerformanceSwap.class;
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
		processRosetta(path.newSubPath("earlyTermination"), processor, CommodityPerformanceSwapEarlyTermination.class, getEarlyTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPerformanceSwapBuilder extends CommodityPerformanceSwap, CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilder {
		CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int _index);
		List<? extends CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> getEarlyTermination();
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductModel(ProductModel productModel);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setId(String id);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg0);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg1, int _idx);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg2);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLeg3);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityContentModel(CommodityContentModel commodityContentModel);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination0);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination1, int _idx);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination2);
		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("commodityPerformanceSwapLeg"), processor, CommodityPerformanceSwapLeg.CommodityPerformanceSwapLegBuilder.class, getCommodityPerformanceSwapLeg());
			processRosetta(path.newSubPath("commodityContentModel"), processor, CommodityContentModel.CommodityContentModelBuilder.class, getCommodityContentModel());
			processRosetta(path.newSubPath("earlyTermination"), processor, CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder.class, getEarlyTermination());
		}
		

		CommodityPerformanceSwap.CommodityPerformanceSwapBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPerformanceSwap  ***********************/
	class CommodityPerformanceSwapImpl extends CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseImpl implements CommodityPerformanceSwap {
		private final List<? extends CommodityPerformanceSwapEarlyTermination> earlyTermination;
		
		protected CommodityPerformanceSwapImpl(CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder) {
			super(builder);
			this.earlyTermination = ofNullable(builder.getEarlyTermination()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("earlyTermination")
		public List<? extends CommodityPerformanceSwapEarlyTermination> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		public CommodityPerformanceSwap build() {
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder() {
			CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPerformanceSwap.CommodityPerformanceSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEarlyTermination()).ifPresent(builder::setEarlyTermination);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwap {" +
				"earlyTermination=" + this.earlyTermination +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPerformanceSwap  ***********************/
	class CommodityPerformanceSwapBuilderImpl extends CommodityPerformanceSwapBase.CommodityPerformanceSwapBaseBuilderImpl  implements CommodityPerformanceSwap.CommodityPerformanceSwapBuilder {
	
		protected List<CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> earlyTermination = new ArrayList<>();
	
		public CommodityPerformanceSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("earlyTermination")
		public List<? extends CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder> getEarlyTermination() {
			return earlyTermination;
		}
		
		public CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int _index) {
		
			if (earlyTermination==null) {
				this.earlyTermination = new ArrayList<>();
			}
			CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder result;
			return getIndex(earlyTermination, _index, () -> {
						CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder newEarlyTermination = CommodityPerformanceSwapEarlyTermination.builder();
						return newEarlyTermination;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementCurrency")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setSettlementCurrency(IdentifiedCurrency settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg) {
			if (commodityPerformanceSwapLeg!=null) this.commodityPerformanceSwapLeg.add(commodityPerformanceSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(CommodityPerformanceSwapLeg commodityPerformanceSwapLeg, int _idx) {
			getIndex(this.commodityPerformanceSwapLeg, _idx, () -> commodityPerformanceSwapLeg.toBuilder());
			return this;
		}
		@Override 
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
			if (commodityPerformanceSwapLegs != null) {
				for (CommodityPerformanceSwapLeg toAdd : commodityPerformanceSwapLegs) {
					this.commodityPerformanceSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("commodityPerformanceSwapLeg")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityPerformanceSwapLeg(List<? extends CommodityPerformanceSwapLeg> commodityPerformanceSwapLegs) {
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
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setCommodityContentModel(CommodityContentModel commodityContentModel) {
			this.commodityContentModel = commodityContentModel==null?null:commodityContentModel.toBuilder();
			return this;
		}
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination) {
			if (earlyTermination!=null) this.earlyTermination.add(earlyTermination.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(CommodityPerformanceSwapEarlyTermination earlyTermination, int _idx) {
			getIndex(this.earlyTermination, _idx, () -> earlyTermination.toBuilder());
			return this;
		}
		@Override 
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder addEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations != null) {
				for (CommodityPerformanceSwapEarlyTermination toAdd : earlyTerminations) {
					this.earlyTermination.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("earlyTermination")
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder setEarlyTermination(List<? extends CommodityPerformanceSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations == null)  {
				this.earlyTermination = new ArrayList<>();
			}
			else {
				this.earlyTermination = earlyTerminations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CommodityPerformanceSwap build() {
			return new CommodityPerformanceSwap.CommodityPerformanceSwapImpl(this);
		}
		
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder prune() {
			super.prune();
			earlyTermination = earlyTermination.stream().filter(b->b!=null).<CommodityPerformanceSwapEarlyTermination.CommodityPerformanceSwapEarlyTerminationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEarlyTermination()!=null && getEarlyTermination().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPerformanceSwap.CommodityPerformanceSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPerformanceSwap.CommodityPerformanceSwapBuilder o = (CommodityPerformanceSwap.CommodityPerformanceSwapBuilder) other;
			
			merger.mergeRosetta(getEarlyTermination(), o.getEarlyTermination(), this::getOrCreateEarlyTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPerformanceSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPerformanceSwapBuilder {" +
				"earlyTermination=" + this.earlyTermination +
			'}' + " " + super.toString();
		}
	}
}
