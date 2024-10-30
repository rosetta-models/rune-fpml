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
import fpml.confirmation.OtcClassification;
import fpml.confirmation.ShortSale;
import fpml.confirmation.TradingWaiver;
import fpml.confirmation.TransactionClassificationModel;
import fpml.confirmation.TransactionClassificationModel.TransactionClassificationModelBuilder;
import fpml.confirmation.TransactionClassificationModel.TransactionClassificationModelBuilderImpl;
import fpml.confirmation.TransactionClassificationModel.TransactionClassificationModelImpl;
import fpml.confirmation.meta.TransactionClassificationModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TransactionClassificationModel", builder=TransactionClassificationModel.TransactionClassificationModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TransactionClassificationModel extends RosettaModelObject {

	TransactionClassificationModelMeta metaData = new TransactionClassificationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Whether the transaction falls within the scope of activity but is exempted from reporting under [Securities Financing Transactions Regulation]
	 */
	Boolean getIsSecuritiesFinancing();
	/**
	 * Classification of the OTC transaction. Note: Coding scheme definition to encapsulate: Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014. e.g. default=&quot;http://www.fpml.org/coding-scheme/esma-mifir-otc-classification&quot;
	 */
	List<? extends OtcClassification> getOtcClassification();
	/**
	 * Classification of the pre-trade waiver, if any, that the transaction was executed under. Note: Coding scheme to encapsulate: Articles 4 and 9 of Regulation (EU) 600/2014. e.g. default=&quot;http://www.fpml.org/coding-scheme/esma-mifir-trading-waiver&quot;
	 */
	List<? extends TradingWaiver> getTradingWaiver();
	/**
	 * Classification of the transaction as a short sale or not and, if short, of the type of transaction. Note: Coding scheme to encapsulate: Article 11 of Regulation (EU) 600/2014. e.g. default=&quot;http://www.fpml.org/coding-scheme/esma-mifir-short-sale&quot;
	 */
	ShortSale getShortSale();
	/**
	 * Whether the transaction reduces risk in an objectively measurable way. Only applicable for commodity derivative transactions.
	 */
	Boolean getIsCommodityHedge();

	/*********************** Build Methods  ***********************/
	TransactionClassificationModel build();
	
	TransactionClassificationModel.TransactionClassificationModelBuilder toBuilder();
	
	static TransactionClassificationModel.TransactionClassificationModelBuilder builder() {
		return new TransactionClassificationModel.TransactionClassificationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransactionClassificationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransactionClassificationModel> getType() {
		return TransactionClassificationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
		processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.class, getOtcClassification());
		processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.class, getTradingWaiver());
		processRosetta(path.newSubPath("shortSale"), processor, ShortSale.class, getShortSale());
		processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransactionClassificationModelBuilder extends TransactionClassificationModel, RosettaModelObjectBuilder {
		OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int _index);
		List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification();
		TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int _index);
		List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver();
		ShortSale.ShortSaleBuilder getOrCreateShortSale();
		ShortSale.ShortSaleBuilder getShortSale();
		TransactionClassificationModel.TransactionClassificationModelBuilder setIsSecuritiesFinancing(Boolean isSecuritiesFinancing);
		TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(OtcClassification otcClassification0);
		TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(OtcClassification otcClassification1, int _idx);
		TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(List<? extends OtcClassification> otcClassification2);
		TransactionClassificationModel.TransactionClassificationModelBuilder setOtcClassification(List<? extends OtcClassification> otcClassification3);
		TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(TradingWaiver tradingWaiver0);
		TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(TradingWaiver tradingWaiver1, int _idx);
		TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(List<? extends TradingWaiver> tradingWaiver2);
		TransactionClassificationModel.TransactionClassificationModelBuilder setTradingWaiver(List<? extends TradingWaiver> tradingWaiver3);
		TransactionClassificationModel.TransactionClassificationModelBuilder setShortSale(ShortSale shortSale);
		TransactionClassificationModel.TransactionClassificationModelBuilder setIsCommodityHedge(Boolean isCommodityHedge);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
			processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.OtcClassificationBuilder.class, getOtcClassification());
			processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.TradingWaiverBuilder.class, getTradingWaiver());
			processRosetta(path.newSubPath("shortSale"), processor, ShortSale.ShortSaleBuilder.class, getShortSale());
			processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
		}
		

		TransactionClassificationModel.TransactionClassificationModelBuilder prune();
	}

	/*********************** Immutable Implementation of TransactionClassificationModel  ***********************/
	class TransactionClassificationModelImpl implements TransactionClassificationModel {
		private final Boolean isSecuritiesFinancing;
		private final List<? extends OtcClassification> otcClassification;
		private final List<? extends TradingWaiver> tradingWaiver;
		private final ShortSale shortSale;
		private final Boolean isCommodityHedge;
		
		protected TransactionClassificationModelImpl(TransactionClassificationModel.TransactionClassificationModelBuilder builder) {
			this.isSecuritiesFinancing = builder.getIsSecuritiesFinancing();
			this.otcClassification = ofNullable(builder.getOtcClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradingWaiver = ofNullable(builder.getTradingWaiver()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.shortSale = ofNullable(builder.getShortSale()).map(f->f.build()).orElse(null);
			this.isCommodityHedge = builder.getIsCommodityHedge();
		}
		
		@Override
		@RosettaAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		public List<? extends OtcClassification> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		public List<? extends TradingWaiver> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		@RosettaAttribute("shortSale")
		public ShortSale getShortSale() {
			return shortSale;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		public TransactionClassificationModel build() {
			return this;
		}
		
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder toBuilder() {
			TransactionClassificationModel.TransactionClassificationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransactionClassificationModel.TransactionClassificationModelBuilder builder) {
			ofNullable(getIsSecuritiesFinancing()).ifPresent(builder::setIsSecuritiesFinancing);
			ofNullable(getOtcClassification()).ifPresent(builder::setOtcClassification);
			ofNullable(getTradingWaiver()).ifPresent(builder::setTradingWaiver);
			ofNullable(getShortSale()).ifPresent(builder::setShortSale);
			ofNullable(getIsCommodityHedge()).ifPresent(builder::setIsCommodityHedge);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionClassificationModel _that = getType().cast(o);
		
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionClassificationModel {" +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge +
			'}';
		}
	}

	/*********************** Builder Implementation of TransactionClassificationModel  ***********************/
	class TransactionClassificationModelBuilderImpl implements TransactionClassificationModel.TransactionClassificationModelBuilder {
	
		protected Boolean isSecuritiesFinancing;
		protected List<OtcClassification.OtcClassificationBuilder> otcClassification = new ArrayList<>();
		protected List<TradingWaiver.TradingWaiverBuilder> tradingWaiver = new ArrayList<>();
		protected ShortSale.ShortSaleBuilder shortSale;
		protected Boolean isCommodityHedge;
	
		public TransactionClassificationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		public List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		public OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int _index) {
		
			if (otcClassification==null) {
				this.otcClassification = new ArrayList<>();
			}
			OtcClassification.OtcClassificationBuilder result;
			return getIndex(otcClassification, _index, () -> {
						OtcClassification.OtcClassificationBuilder newOtcClassification = OtcClassification.builder();
						return newOtcClassification;
					});
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		public List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		public TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int _index) {
		
			if (tradingWaiver==null) {
				this.tradingWaiver = new ArrayList<>();
			}
			TradingWaiver.TradingWaiverBuilder result;
			return getIndex(tradingWaiver, _index, () -> {
						TradingWaiver.TradingWaiverBuilder newTradingWaiver = TradingWaiver.builder();
						return newTradingWaiver;
					});
		}
		
		@Override
		@RosettaAttribute("shortSale")
		public ShortSale.ShortSaleBuilder getShortSale() {
			return shortSale;
		}
		
		@Override
		public ShortSale.ShortSaleBuilder getOrCreateShortSale() {
			ShortSale.ShortSaleBuilder result;
			if (shortSale!=null) {
				result = shortSale;
			}
			else {
				result = shortSale = ShortSale.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		@RosettaAttribute("isSecuritiesFinancing")
		public TransactionClassificationModel.TransactionClassificationModelBuilder setIsSecuritiesFinancing(Boolean isSecuritiesFinancing) {
			this.isSecuritiesFinancing = isSecuritiesFinancing==null?null:isSecuritiesFinancing;
			return this;
		}
		@Override
		@RosettaAttribute("otcClassification")
		public TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(OtcClassification otcClassification) {
			if (otcClassification!=null) this.otcClassification.add(otcClassification.toBuilder());
			return this;
		}
		
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(OtcClassification otcClassification, int _idx) {
			getIndex(this.otcClassification, _idx, () -> otcClassification.toBuilder());
			return this;
		}
		@Override 
		public TransactionClassificationModel.TransactionClassificationModelBuilder addOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications != null) {
				for (OtcClassification toAdd : otcClassifications) {
					this.otcClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TransactionClassificationModel.TransactionClassificationModelBuilder setOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications == null)  {
				this.otcClassification = new ArrayList<>();
			}
			else {
				this.otcClassification = otcClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		public TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(TradingWaiver tradingWaiver) {
			if (tradingWaiver!=null) this.tradingWaiver.add(tradingWaiver.toBuilder());
			return this;
		}
		
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(TradingWaiver tradingWaiver, int _idx) {
			getIndex(this.tradingWaiver, _idx, () -> tradingWaiver.toBuilder());
			return this;
		}
		@Override 
		public TransactionClassificationModel.TransactionClassificationModelBuilder addTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers != null) {
				for (TradingWaiver toAdd : tradingWaivers) {
					this.tradingWaiver.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TransactionClassificationModel.TransactionClassificationModelBuilder setTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers == null)  {
				this.tradingWaiver = new ArrayList<>();
			}
			else {
				this.tradingWaiver = tradingWaivers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("shortSale")
		public TransactionClassificationModel.TransactionClassificationModelBuilder setShortSale(ShortSale shortSale) {
			this.shortSale = shortSale==null?null:shortSale.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCommodityHedge")
		public TransactionClassificationModel.TransactionClassificationModelBuilder setIsCommodityHedge(Boolean isCommodityHedge) {
			this.isCommodityHedge = isCommodityHedge==null?null:isCommodityHedge;
			return this;
		}
		
		@Override
		public TransactionClassificationModel build() {
			return new TransactionClassificationModel.TransactionClassificationModelImpl(this);
		}
		
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder prune() {
			otcClassification = otcClassification.stream().filter(b->b!=null).<OtcClassification.OtcClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradingWaiver = tradingWaiver.stream().filter(b->b!=null).<TradingWaiver.TradingWaiverBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (shortSale!=null && !shortSale.prune().hasData()) shortSale = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsSecuritiesFinancing()!=null) return true;
			if (getOtcClassification()!=null && getOtcClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradingWaiver()!=null && getTradingWaiver().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getShortSale()!=null && getShortSale().hasData()) return true;
			if (getIsCommodityHedge()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransactionClassificationModel.TransactionClassificationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransactionClassificationModel.TransactionClassificationModelBuilder o = (TransactionClassificationModel.TransactionClassificationModelBuilder) other;
			
			merger.mergeRosetta(getOtcClassification(), o.getOtcClassification(), this::getOrCreateOtcClassification);
			merger.mergeRosetta(getTradingWaiver(), o.getTradingWaiver(), this::getOrCreateTradingWaiver);
			merger.mergeRosetta(getShortSale(), o.getShortSale(), this::setShortSale);
			
			merger.mergeBasic(getIsSecuritiesFinancing(), o.getIsSecuritiesFinancing(), this::setIsSecuritiesFinancing);
			merger.mergeBasic(getIsCommodityHedge(), o.getIsCommodityHedge(), this::setIsCommodityHedge);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransactionClassificationModel _that = getType().cast(o);
		
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransactionClassificationModelBuilder {" +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge +
			'}';
		}
	}
}
