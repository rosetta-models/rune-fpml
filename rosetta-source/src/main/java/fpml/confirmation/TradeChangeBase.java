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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.PartyTradeIdentifier;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeChangeBase;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseBuilder;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseBuilderImpl;
import fpml.confirmation.TradeChangeBase.TradeChangeBaseImpl;
import fpml.confirmation.meta.TradeChangeBaseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a trade change.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeChangeBase", builder=TradeChangeBase.TradeChangeBaseBuilderImpl.class, version="${project.version}")
public interface TradeChangeBase extends AbstractEvent {

	TradeChangeBaseMeta metaData = new TradeChangeBaseMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends PartyTradeIdentifier> getTradeIdentifier();
	Trade getOriginalTrade();
	Trade getResultingTrade();
	AgreementAndEffectiveDatesModel getAgreementAndEffectiveDatesModel();
	TradeAlterationPaymentModel getTradeAlterationPaymentModel();

	/*********************** Build Methods  ***********************/
	TradeChangeBase build();
	
	TradeChangeBase.TradeChangeBaseBuilder toBuilder();
	
	static TradeChangeBase.TradeChangeBaseBuilder builder() {
		return new TradeChangeBase.TradeChangeBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeChangeBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeChangeBase> getType() {
		return TradeChangeBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("originalTrade"), processor, Trade.class, getOriginalTrade());
		processRosetta(path.newSubPath("resultingTrade"), processor, Trade.class, getResultingTrade());
		processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.class, getAgreementAndEffectiveDatesModel());
		processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.class, getTradeAlterationPaymentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeChangeBaseBuilder extends TradeChangeBase, AbstractEvent.AbstractEventBuilder {
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index);
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier();
		Trade.TradeBuilder getOrCreateOriginalTrade();
		Trade.TradeBuilder getOriginalTrade();
		Trade.TradeBuilder getOrCreateResultingTrade();
		Trade.TradeBuilder getResultingTrade();
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getOrCreateAgreementAndEffectiveDatesModel();
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getAgreementAndEffectiveDatesModel();
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getOrCreateTradeAlterationPaymentModel();
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getTradeAlterationPaymentModel();
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		TradeChangeBase.TradeChangeBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier0);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier1, int _idx);
		TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier2);
		TradeChangeBase.TradeChangeBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifier3);
		TradeChangeBase.TradeChangeBaseBuilder setOriginalTrade(Trade originalTrade);
		TradeChangeBase.TradeChangeBaseBuilder setResultingTrade(Trade resultingTrade);
		TradeChangeBase.TradeChangeBaseBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel);
		TradeChangeBase.TradeChangeBaseBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("originalTrade"), processor, Trade.TradeBuilder.class, getOriginalTrade());
			processRosetta(path.newSubPath("resultingTrade"), processor, Trade.TradeBuilder.class, getResultingTrade());
			processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder.class, getAgreementAndEffectiveDatesModel());
			processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder.class, getTradeAlterationPaymentModel());
		}
		

		TradeChangeBase.TradeChangeBaseBuilder prune();
	}

	/*********************** Immutable Implementation of TradeChangeBase  ***********************/
	class TradeChangeBaseImpl extends AbstractEvent.AbstractEventImpl implements TradeChangeBase {
		private final List<? extends PartyTradeIdentifier> tradeIdentifier;
		private final Trade originalTrade;
		private final Trade resultingTrade;
		private final AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel;
		private final TradeAlterationPaymentModel tradeAlterationPaymentModel;
		
		protected TradeChangeBaseImpl(TradeChangeBase.TradeChangeBaseBuilder builder) {
			super(builder);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.originalTrade = ofNullable(builder.getOriginalTrade()).map(f->f.build()).orElse(null);
			this.resultingTrade = ofNullable(builder.getResultingTrade()).map(f->f.build()).orElse(null);
			this.agreementAndEffectiveDatesModel = ofNullable(builder.getAgreementAndEffectiveDatesModel()).map(f->f.build()).orElse(null);
			this.tradeAlterationPaymentModel = ofNullable(builder.getTradeAlterationPaymentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public Trade getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		public Trade getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public AgreementAndEffectiveDatesModel getAgreementAndEffectiveDatesModel() {
			return agreementAndEffectiveDatesModel;
		}
		
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeAlterationPaymentModel getTradeAlterationPaymentModel() {
			return tradeAlterationPaymentModel;
		}
		
		@Override
		public TradeChangeBase build() {
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder toBuilder() {
			TradeChangeBase.TradeChangeBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeChangeBase.TradeChangeBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getOriginalTrade()).ifPresent(builder::setOriginalTrade);
			ofNullable(getResultingTrade()).ifPresent(builder::setResultingTrade);
			ofNullable(getAgreementAndEffectiveDatesModel()).ifPresent(builder::setAgreementAndEffectiveDatesModel);
			ofNullable(getTradeAlterationPaymentModel()).ifPresent(builder::setTradeAlterationPaymentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(agreementAndEffectiveDatesModel, _that.getAgreementAndEffectiveDatesModel())) return false;
			if (!Objects.equals(tradeAlterationPaymentModel, _that.getTradeAlterationPaymentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (agreementAndEffectiveDatesModel != null ? agreementAndEffectiveDatesModel.hashCode() : 0);
			_result = 31 * _result + (tradeAlterationPaymentModel != null ? tradeAlterationPaymentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeBase {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"agreementAndEffectiveDatesModel=" + this.agreementAndEffectiveDatesModel + ", " +
				"tradeAlterationPaymentModel=" + this.tradeAlterationPaymentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeChangeBase  ***********************/
	class TradeChangeBaseBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements TradeChangeBase.TradeChangeBaseBuilder {
	
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected Trade.TradeBuilder originalTrade;
		protected Trade.TradeBuilder resultingTrade;
		protected AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder agreementAndEffectiveDatesModel;
		protected TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder tradeAlterationPaymentModel;
	
		public TradeChangeBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreateTradeIdentifier(int _index) {
		
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			return getIndex(tradeIdentifier, _index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newTradeIdentifier = PartyTradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("originalTrade")
		public Trade.TradeBuilder getOriginalTrade() {
			return originalTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateOriginalTrade() {
			Trade.TradeBuilder result;
			if (originalTrade!=null) {
				result = originalTrade;
			}
			else {
				result = originalTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("resultingTrade")
		public Trade.TradeBuilder getResultingTrade() {
			return resultingTrade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateResultingTrade() {
			Trade.TradeBuilder result;
			if (resultingTrade!=null) {
				result = resultingTrade;
			}
			else {
				result = resultingTrade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getAgreementAndEffectiveDatesModel() {
			return agreementAndEffectiveDatesModel;
		}
		
		@Override
		public AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getOrCreateAgreementAndEffectiveDatesModel() {
			AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder result;
			if (agreementAndEffectiveDatesModel!=null) {
				result = agreementAndEffectiveDatesModel;
			}
			else {
				result = agreementAndEffectiveDatesModel = AgreementAndEffectiveDatesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getTradeAlterationPaymentModel() {
			return tradeAlterationPaymentModel;
		}
		
		@Override
		public TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getOrCreateTradeAlterationPaymentModel() {
			TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder result;
			if (tradeAlterationPaymentModel!=null) {
				result = tradeAlterationPaymentModel;
			}
			else {
				result = tradeAlterationPaymentModel = TradeAlterationPaymentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeChangeBase.TradeChangeBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeChangeBase.TradeChangeBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier) {
			if (tradeIdentifier!=null) this.tradeIdentifier.add(tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(PartyTradeIdentifier tradeIdentifier, int _idx) {
			getIndex(this.tradeIdentifier, _idx, () -> tradeIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeChangeBase.TradeChangeBaseBuilder addTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (PartyTradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public TradeChangeBase.TradeChangeBaseBuilder setTradeIdentifier(List<? extends PartyTradeIdentifier> tradeIdentifiers) {
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
		public TradeChangeBase.TradeChangeBaseBuilder setOriginalTrade(Trade originalTrade) {
			this.originalTrade = originalTrade==null?null:originalTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("resultingTrade")
		public TradeChangeBase.TradeChangeBaseBuilder setResultingTrade(Trade resultingTrade) {
			this.resultingTrade = resultingTrade==null?null:resultingTrade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public TradeChangeBase.TradeChangeBaseBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel) {
			this.agreementAndEffectiveDatesModel = agreementAndEffectiveDatesModel==null?null:agreementAndEffectiveDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeChangeBase.TradeChangeBaseBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel) {
			this.tradeAlterationPaymentModel = tradeAlterationPaymentModel==null?null:tradeAlterationPaymentModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeChangeBase build() {
			return new TradeChangeBase.TradeChangeBaseImpl(this);
		}
		
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder prune() {
			super.prune();
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (originalTrade!=null && !originalTrade.prune().hasData()) originalTrade = null;
			if (resultingTrade!=null && !resultingTrade.prune().hasData()) resultingTrade = null;
			if (agreementAndEffectiveDatesModel!=null && !agreementAndEffectiveDatesModel.prune().hasData()) agreementAndEffectiveDatesModel = null;
			if (tradeAlterationPaymentModel!=null && !tradeAlterationPaymentModel.prune().hasData()) tradeAlterationPaymentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOriginalTrade()!=null && getOriginalTrade().hasData()) return true;
			if (getResultingTrade()!=null && getResultingTrade().hasData()) return true;
			if (getAgreementAndEffectiveDatesModel()!=null && getAgreementAndEffectiveDatesModel().hasData()) return true;
			if (getTradeAlterationPaymentModel()!=null && getTradeAlterationPaymentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeChangeBase.TradeChangeBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeChangeBase.TradeChangeBaseBuilder o = (TradeChangeBase.TradeChangeBaseBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getOriginalTrade(), o.getOriginalTrade(), this::setOriginalTrade);
			merger.mergeRosetta(getResultingTrade(), o.getResultingTrade(), this::setResultingTrade);
			merger.mergeRosetta(getAgreementAndEffectiveDatesModel(), o.getAgreementAndEffectiveDatesModel(), this::setAgreementAndEffectiveDatesModel);
			merger.mergeRosetta(getTradeAlterationPaymentModel(), o.getTradeAlterationPaymentModel(), this::setTradeAlterationPaymentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeChangeBase _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(originalTrade, _that.getOriginalTrade())) return false;
			if (!Objects.equals(resultingTrade, _that.getResultingTrade())) return false;
			if (!Objects.equals(agreementAndEffectiveDatesModel, _that.getAgreementAndEffectiveDatesModel())) return false;
			if (!Objects.equals(tradeAlterationPaymentModel, _that.getTradeAlterationPaymentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (originalTrade != null ? originalTrade.hashCode() : 0);
			_result = 31 * _result + (resultingTrade != null ? resultingTrade.hashCode() : 0);
			_result = 31 * _result + (agreementAndEffectiveDatesModel != null ? agreementAndEffectiveDatesModel.hashCode() : 0);
			_result = 31 * _result + (tradeAlterationPaymentModel != null ? tradeAlterationPaymentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeChangeBaseBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"originalTrade=" + this.originalTrade + ", " +
				"resultingTrade=" + this.resultingTrade + ", " +
				"agreementAndEffectiveDatesModel=" + this.agreementAndEffectiveDatesModel + ", " +
				"tradeAlterationPaymentModel=" + this.tradeAlterationPaymentModel +
			'}' + " " + super.toString();
		}
	}
}
