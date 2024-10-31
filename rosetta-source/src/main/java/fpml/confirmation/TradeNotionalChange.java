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
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeChangeBase;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseBuilder;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseBuilderImpl;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseImpl;
import fpml.confirmation.TradeLegPriceChange;
import fpml.confirmation.TradeLegSizeChange;
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.TradeNotionalChange.TradeNotionalChangeBuilder;
import fpml.confirmation.TradeNotionalChange.TradeNotionalChangeBuilderImpl;
import fpml.confirmation.TradeNotionalChange.TradeNotionalChangeImpl;
import fpml.confirmation.TradeNotionalChangeModel;
import fpml.confirmation.meta.TradeNotionalChangeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a change to the size of a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNotionalChange", builder=TradeNotionalChange.TradeNotionalChangeBuilderImpl.class, version="${project.version}")
public interface TradeNotionalChange extends TradeChangeBase {

	TradeNotionalChangeMeta metaData = new TradeNotionalChangeMeta();

	/*********************** Getter Methods  ***********************/
	TradeNotionalChangeModel getTradeNotionalChangeModel();
	List<? extends TradeLegSizeChange> getSizeChange();
	List<? extends TradeLegPriceChange> getPriceChange();

	/*********************** Build Methods  ***********************/
	TradeNotionalChange build();
	
	TradeNotionalChange.TradeNotionalChangeBuilder toBuilder();
	
	static TradeNotionalChange.TradeNotionalChangeBuilder builder() {
		return new TradeNotionalChange.TradeNotionalChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNotionalChange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeNotionalChange> getType() {
		return TradeNotionalChange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("resultingTrade"), processor, Trade.class, getResultingTrade());
		processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.class, getAgreementAndEffectiveDatesModel());
		processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.class, getTradeAlterationPaymentModel());
		processRosetta(path.newSubPath("tradeNotionalChangeModel"), processor, TradeNotionalChangeModel.class, getTradeNotionalChangeModel());
		processRosetta(path.newSubPath("sizeChange"), processor, TradeLegSizeChange.class, getSizeChange());
		processRosetta(path.newSubPath("priceChange"), processor, TradeLegPriceChange.class, getPriceChange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNotionalChangeBuilder extends TradeNotionalChange, TradeChangeBase.TradeChangeBaseBuilder {
		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder getOrCreateTradeNotionalChangeModel();
		TradeNotionalChangeModel.TradeNotionalChangeModelBuilder getTradeNotionalChangeModel();
		TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateSizeChange(int _index);
		List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getSizeChange();
		TradeLegPriceChange.TradeLegPriceChangeBuilder getOrCreatePriceChange(int _index);
		List<? extends TradeLegPriceChange.TradeLegPriceChangeBuilder> getPriceChange();
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		TradeNotionalChange.TradeNotionalChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		TradeNotionalChange.TradeNotionalChangeBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		TradeNotionalChange.TradeNotionalChangeBuilder setOriginalTrade(Trade originalTrade);
		TradeNotionalChange.TradeNotionalChangeBuilder setResultingTrade(Trade resultingTrade);
		TradeNotionalChange.TradeNotionalChangeBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel);
		TradeNotionalChange.TradeNotionalChangeBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel);
		TradeNotionalChange.TradeNotionalChangeBuilder setTradeNotionalChangeModel(TradeNotionalChangeModel tradeNotionalChangeModel);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange0);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange1, int _idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(List<? extends TradeLegSizeChange> sizeChange2);
		TradeNotionalChange.TradeNotionalChangeBuilder setSizeChange(List<? extends TradeLegSizeChange> sizeChange3);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange0);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange1, int _idx);
		TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(List<? extends TradeLegPriceChange> priceChange2);
		TradeNotionalChange.TradeNotionalChangeBuilder setPriceChange(List<? extends TradeLegPriceChange> priceChange3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("resultingTrade"), processor, Trade.TradeBuilder.class, getResultingTrade());
			processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder.class, getAgreementAndEffectiveDatesModel());
			processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder.class, getTradeAlterationPaymentModel());
			processRosetta(path.newSubPath("tradeNotionalChangeModel"), processor, TradeNotionalChangeModel.TradeNotionalChangeModelBuilder.class, getTradeNotionalChangeModel());
			processRosetta(path.newSubPath("sizeChange"), processor, TradeLegSizeChange.TradeLegSizeChangeBuilder.class, getSizeChange());
			processRosetta(path.newSubPath("priceChange"), processor, TradeLegPriceChange.TradeLegPriceChangeBuilder.class, getPriceChange());
		}
		

		TradeNotionalChange.TradeNotionalChangeBuilder prune();
	}

	/*********************** Immutable Implementation of TradeNotionalChange  ***********************/
	class TradeNotionalChangeImpl extends TradeChangeBase.TradeChangeBaseImpl implements TradeNotionalChange {
		private final TradeNotionalChangeModel tradeNotionalChangeModel;
		private final List<? extends TradeLegSizeChange> sizeChange;
		private final List<? extends TradeLegPriceChange> priceChange;
		
		protected TradeNotionalChangeImpl(TradeNotionalChange.TradeNotionalChangeBuilder builder) {
			super(builder);
			this.tradeNotionalChangeModel = ofNullable(builder.getTradeNotionalChangeModel()).map(f->f.build()).orElse(null);
			this.sizeChange = ofNullable(builder.getSizeChange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.priceChange = ofNullable(builder.getPriceChange()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeNotionalChangeModel")
		public TradeNotionalChangeModel getTradeNotionalChangeModel() {
			return tradeNotionalChangeModel;
		}
		
		@Override
		@RosettaAttribute("sizeChange")
		public List<? extends TradeLegSizeChange> getSizeChange() {
			return sizeChange;
		}
		
		@Override
		@RosettaAttribute("priceChange")
		public List<? extends TradeLegPriceChange> getPriceChange() {
			return priceChange;
		}
		
		@Override
		public TradeNotionalChange build() {
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder toBuilder() {
			TradeNotionalChange.TradeNotionalChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNotionalChange.TradeNotionalChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeNotionalChangeModel()).ifPresent(builder::setTradeNotionalChangeModel);
			ofNullable(getSizeChange()).ifPresent(builder::setSizeChange);
			ofNullable(getPriceChange()).ifPresent(builder::setPriceChange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNotionalChange _that = getType().cast(o);
		
			if (!Objects.equals(tradeNotionalChangeModel, _that.getTradeNotionalChangeModel())) return false;
			if (!ListEquals.listEquals(sizeChange, _that.getSizeChange())) return false;
			if (!ListEquals.listEquals(priceChange, _that.getPriceChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeNotionalChangeModel != null ? tradeNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (sizeChange != null ? sizeChange.hashCode() : 0);
			_result = 31 * _result + (priceChange != null ? priceChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChange {" +
				"tradeNotionalChangeModel=" + this.tradeNotionalChangeModel + ", " +
				"sizeChange=" + this.sizeChange + ", " +
				"priceChange=" + this.priceChange +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeNotionalChange  ***********************/
	class TradeNotionalChangeBuilderImpl extends TradeChangeBase.TradeChangeBaseBuilderImpl  implements TradeNotionalChange.TradeNotionalChangeBuilder {
	
		protected TradeNotionalChangeModel.TradeNotionalChangeModelBuilder tradeNotionalChangeModel;
		protected List<TradeLegSizeChange.TradeLegSizeChangeBuilder> sizeChange = new ArrayList<>();
		protected List<TradeLegPriceChange.TradeLegPriceChangeBuilder> priceChange = new ArrayList<>();
	
		public TradeNotionalChangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeNotionalChangeModel")
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder getTradeNotionalChangeModel() {
			return tradeNotionalChangeModel;
		}
		
		@Override
		public TradeNotionalChangeModel.TradeNotionalChangeModelBuilder getOrCreateTradeNotionalChangeModel() {
			TradeNotionalChangeModel.TradeNotionalChangeModelBuilder result;
			if (tradeNotionalChangeModel!=null) {
				result = tradeNotionalChangeModel;
			}
			else {
				result = tradeNotionalChangeModel = TradeNotionalChangeModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sizeChange")
		public List<? extends TradeLegSizeChange.TradeLegSizeChangeBuilder> getSizeChange() {
			return sizeChange;
		}
		
		@Override
		public TradeLegSizeChange.TradeLegSizeChangeBuilder getOrCreateSizeChange(int _index) {
		
			if (sizeChange==null) {
				this.sizeChange = new ArrayList<>();
			}
			TradeLegSizeChange.TradeLegSizeChangeBuilder result;
			return getIndex(sizeChange, _index, () -> {
						TradeLegSizeChange.TradeLegSizeChangeBuilder newSizeChange = TradeLegSizeChange.builder();
						return newSizeChange;
					});
		}
		
		@Override
		@RosettaAttribute("priceChange")
		public List<? extends TradeLegPriceChange.TradeLegPriceChangeBuilder> getPriceChange() {
			return priceChange;
		}
		
		@Override
		public TradeLegPriceChange.TradeLegPriceChangeBuilder getOrCreatePriceChange(int _index) {
		
			if (priceChange==null) {
				this.priceChange = new ArrayList<>();
			}
			TradeLegPriceChange.TradeLegPriceChangeBuilder result;
			return getIndex(priceChange, _index, () -> {
						TradeLegPriceChange.TradeLegPriceChangeBuilder newPriceChange = TradeLegPriceChange.builder();
						return newPriceChange;
					});
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null)  {
				this.tradeIdentifier = new ArrayList<>();
			}
			else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public TradeNotionalChange.TradeNotionalChangeBuilder setOriginalTrade(Trade originalTrade) {
			this.originalTrade = originalTrade==null?null:originalTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resultingTrade")
		public TradeNotionalChange.TradeNotionalChangeBuilder setResultingTrade(Trade resultingTrade) {
			this.resultingTrade = resultingTrade==null?null:resultingTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public TradeNotionalChange.TradeNotionalChangeBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel) {
			this.agreementAndEffectiveDatesModel = agreementAndEffectiveDatesModel==null?null:agreementAndEffectiveDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeNotionalChange.TradeNotionalChangeBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel) {
			this.tradeAlterationPaymentModel = tradeAlterationPaymentModel==null?null:tradeAlterationPaymentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeNotionalChangeModel")
		public TradeNotionalChange.TradeNotionalChangeBuilder setTradeNotionalChangeModel(TradeNotionalChangeModel tradeNotionalChangeModel) {
			this.tradeNotionalChangeModel = tradeNotionalChangeModel==null?null:tradeNotionalChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("sizeChange")
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange) {
			if (sizeChange!=null) this.sizeChange.add(sizeChange.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(TradeLegSizeChange sizeChange, int _idx) {
			getIndex(this.sizeChange, _idx, () -> sizeChange.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder addSizeChange(List<? extends TradeLegSizeChange> sizeChanges) {
			if (sizeChanges != null) {
				for (TradeLegSizeChange toAdd : sizeChanges) {
					this.sizeChange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder setSizeChange(List<? extends TradeLegSizeChange> sizeChanges) {
			if (sizeChanges == null)  {
				this.sizeChange = new ArrayList<>();
			}
			else {
				this.sizeChange = sizeChanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("priceChange")
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange) {
			if (priceChange!=null) this.priceChange.add(priceChange.toBuilder());
			return this;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(TradeLegPriceChange priceChange, int _idx) {
			getIndex(this.priceChange, _idx, () -> priceChange.toBuilder());
			return this;
		}
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder addPriceChange(List<? extends TradeLegPriceChange> priceChanges) {
			if (priceChanges != null) {
				for (TradeLegPriceChange toAdd : priceChanges) {
					this.priceChange.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeNotionalChange.TradeNotionalChangeBuilder setPriceChange(List<? extends TradeLegPriceChange> priceChanges) {
			if (priceChanges == null)  {
				this.priceChange = new ArrayList<>();
			}
			else {
				this.priceChange = priceChanges.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TradeNotionalChange build() {
			return new TradeNotionalChange.TradeNotionalChangeImpl(this);
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder prune() {
			super.prune();
			if (tradeNotionalChangeModel!=null && !tradeNotionalChangeModel.prune().hasData()) tradeNotionalChangeModel = null;
			sizeChange = sizeChange.stream().filter(b->b!=null).<TradeLegSizeChange.TradeLegSizeChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			priceChange = priceChange.stream().filter(b->b!=null).<TradeLegPriceChange.TradeLegPriceChangeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeNotionalChangeModel()!=null && getTradeNotionalChangeModel().hasData()) return true;
			if (getSizeChange()!=null && getSizeChange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPriceChange()!=null && getPriceChange().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeNotionalChange.TradeNotionalChangeBuilder o = (TradeNotionalChange.TradeNotionalChangeBuilder) other;
			
			merger.mergeRosetta(getTradeNotionalChangeModel(), o.getTradeNotionalChangeModel(), this::setTradeNotionalChangeModel);
			merger.mergeRosetta(getSizeChange(), o.getSizeChange(), this::getOrCreateSizeChange);
			merger.mergeRosetta(getPriceChange(), o.getPriceChange(), this::getOrCreatePriceChange);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeNotionalChange _that = getType().cast(o);
		
			if (!Objects.equals(tradeNotionalChangeModel, _that.getTradeNotionalChangeModel())) return false;
			if (!ListEquals.listEquals(sizeChange, _that.getSizeChange())) return false;
			if (!ListEquals.listEquals(priceChange, _that.getPriceChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeNotionalChangeModel != null ? tradeNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (sizeChange != null ? sizeChange.hashCode() : 0);
			_result = 31 * _result + (priceChange != null ? priceChange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNotionalChangeBuilder {" +
				"tradeNotionalChangeModel=" + this.tradeNotionalChangeModel + ", " +
				"sizeChange=" + this.sizeChange + ", " +
				"priceChange=" + this.priceChange +
			'}' + " " + super.toString();
		}
	}
}
