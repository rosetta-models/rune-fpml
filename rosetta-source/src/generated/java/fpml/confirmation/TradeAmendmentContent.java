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
import fpml.confirmation.AbstractEvent;
import fpml.confirmation.AbstractEvent.AbstractEventBuilder;
import fpml.confirmation.AbstractEvent.AbstractEventBuilderImpl;
import fpml.confirmation.AbstractEvent.AbstractEventImpl;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ReportingNotionalChangeModel;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeAmendmentContent;
import fpml.confirmation.TradeAmendmentContent.TradeAmendmentContentBuilder;
import fpml.confirmation.TradeAmendmentContent.TradeAmendmentContentBuilderImpl;
import fpml.confirmation.TradeAmendmentContent.TradeAmendmentContentImpl;
import fpml.confirmation.meta.TradeAmendmentContentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing a negotiated amendment.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeAmendmentContent", builder=TradeAmendmentContent.TradeAmendmentContentBuilderImpl.class, version="${project.version}")
public interface TradeAmendmentContent extends AbstractEvent {

	TradeAmendmentContentMeta metaData = new TradeAmendmentContentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A full description of the amended trade (i.e. the trade after the amendment).
	 */
	Trade getTrade();
	AgreementAndEffectiveDatesModel getAgreementAndEffectiveDatesModel();
	ReportingNotionalChangeModel getReportingNotionalChangeModel();
	TradeAlterationPaymentModel getTradeAlterationPaymentModel();

	/*********************** Build Methods  ***********************/
	TradeAmendmentContent build();
	
	TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder();
	
	static TradeAmendmentContent.TradeAmendmentContentBuilder builder() {
		return new TradeAmendmentContent.TradeAmendmentContentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeAmendmentContent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeAmendmentContent> getType() {
		return TradeAmendmentContent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.class, getAgreementAndEffectiveDatesModel());
		processRosetta(path.newSubPath("reportingNotionalChangeModel"), processor, ReportingNotionalChangeModel.class, getReportingNotionalChangeModel());
		processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.class, getTradeAlterationPaymentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeAmendmentContentBuilder extends TradeAmendmentContent, AbstractEvent.AbstractEventBuilder {
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getOrCreateAgreementAndEffectiveDatesModel();
		AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder getAgreementAndEffectiveDatesModel();
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder getOrCreateReportingNotionalChangeModel();
		ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder getReportingNotionalChangeModel();
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getOrCreateTradeAlterationPaymentModel();
		TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder getTradeAlterationPaymentModel();
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		TradeAmendmentContent.TradeAmendmentContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		TradeAmendmentContent.TradeAmendmentContentBuilder setTrade(Trade trade);
		TradeAmendmentContent.TradeAmendmentContentBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel);
		TradeAmendmentContent.TradeAmendmentContentBuilder setReportingNotionalChangeModel(ReportingNotionalChangeModel reportingNotionalChangeModel);
		TradeAmendmentContent.TradeAmendmentContentBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("agreementAndEffectiveDatesModel"), processor, AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder.class, getAgreementAndEffectiveDatesModel());
			processRosetta(path.newSubPath("reportingNotionalChangeModel"), processor, ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder.class, getReportingNotionalChangeModel());
			processRosetta(path.newSubPath("tradeAlterationPaymentModel"), processor, TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder.class, getTradeAlterationPaymentModel());
		}
		

		TradeAmendmentContent.TradeAmendmentContentBuilder prune();
	}

	/*********************** Immutable Implementation of TradeAmendmentContent  ***********************/
	class TradeAmendmentContentImpl extends AbstractEvent.AbstractEventImpl implements TradeAmendmentContent {
		private final Trade trade;
		private final AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel;
		private final ReportingNotionalChangeModel reportingNotionalChangeModel;
		private final TradeAlterationPaymentModel tradeAlterationPaymentModel;
		
		protected TradeAmendmentContentImpl(TradeAmendmentContent.TradeAmendmentContentBuilder builder) {
			super(builder);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.agreementAndEffectiveDatesModel = ofNullable(builder.getAgreementAndEffectiveDatesModel()).map(f->f.build()).orElse(null);
			this.reportingNotionalChangeModel = ofNullable(builder.getReportingNotionalChangeModel()).map(f->f.build()).orElse(null);
			this.tradeAlterationPaymentModel = ofNullable(builder.getTradeAlterationPaymentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public AgreementAndEffectiveDatesModel getAgreementAndEffectiveDatesModel() {
			return agreementAndEffectiveDatesModel;
		}
		
		@Override
		@RosettaAttribute("reportingNotionalChangeModel")
		public ReportingNotionalChangeModel getReportingNotionalChangeModel() {
			return reportingNotionalChangeModel;
		}
		
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeAlterationPaymentModel getTradeAlterationPaymentModel() {
			return tradeAlterationPaymentModel;
		}
		
		@Override
		public TradeAmendmentContent build() {
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder() {
			TradeAmendmentContent.TradeAmendmentContentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeAmendmentContent.TradeAmendmentContentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getAgreementAndEffectiveDatesModel()).ifPresent(builder::setAgreementAndEffectiveDatesModel);
			ofNullable(getReportingNotionalChangeModel()).ifPresent(builder::setReportingNotionalChangeModel);
			ofNullable(getTradeAlterationPaymentModel()).ifPresent(builder::setTradeAlterationPaymentModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeAmendmentContent _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(agreementAndEffectiveDatesModel, _that.getAgreementAndEffectiveDatesModel())) return false;
			if (!Objects.equals(reportingNotionalChangeModel, _that.getReportingNotionalChangeModel())) return false;
			if (!Objects.equals(tradeAlterationPaymentModel, _that.getTradeAlterationPaymentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (agreementAndEffectiveDatesModel != null ? agreementAndEffectiveDatesModel.hashCode() : 0);
			_result = 31 * _result + (reportingNotionalChangeModel != null ? reportingNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeAlterationPaymentModel != null ? tradeAlterationPaymentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeAmendmentContent {" +
				"trade=" + this.trade + ", " +
				"agreementAndEffectiveDatesModel=" + this.agreementAndEffectiveDatesModel + ", " +
				"reportingNotionalChangeModel=" + this.reportingNotionalChangeModel + ", " +
				"tradeAlterationPaymentModel=" + this.tradeAlterationPaymentModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of TradeAmendmentContent  ***********************/
	class TradeAmendmentContentBuilderImpl extends AbstractEvent.AbstractEventBuilderImpl  implements TradeAmendmentContent.TradeAmendmentContentBuilder {
	
		protected Trade.TradeBuilder trade;
		protected AgreementAndEffectiveDatesModel.AgreementAndEffectiveDatesModelBuilder agreementAndEffectiveDatesModel;
		protected ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder reportingNotionalChangeModel;
		protected TradeAlterationPaymentModel.TradeAlterationPaymentModelBuilder tradeAlterationPaymentModel;
	
		public TradeAmendmentContentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
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
		@RosettaAttribute("reportingNotionalChangeModel")
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder getReportingNotionalChangeModel() {
			return reportingNotionalChangeModel;
		}
		
		@Override
		public ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder getOrCreateReportingNotionalChangeModel() {
			ReportingNotionalChangeModel.ReportingNotionalChangeModelBuilder result;
			if (reportingNotionalChangeModel!=null) {
				result = reportingNotionalChangeModel;
			}
			else {
				result = reportingNotionalChangeModel = ReportingNotionalChangeModel.builder();
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
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public TradeAmendmentContent.TradeAmendmentContentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public TradeAmendmentContent.TradeAmendmentContentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		@RosettaAttribute("trade")
		public TradeAmendmentContent.TradeAmendmentContentBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("agreementAndEffectiveDatesModel")
		public TradeAmendmentContent.TradeAmendmentContentBuilder setAgreementAndEffectiveDatesModel(AgreementAndEffectiveDatesModel agreementAndEffectiveDatesModel) {
			this.agreementAndEffectiveDatesModel = agreementAndEffectiveDatesModel==null?null:agreementAndEffectiveDatesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("reportingNotionalChangeModel")
		public TradeAmendmentContent.TradeAmendmentContentBuilder setReportingNotionalChangeModel(ReportingNotionalChangeModel reportingNotionalChangeModel) {
			this.reportingNotionalChangeModel = reportingNotionalChangeModel==null?null:reportingNotionalChangeModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeAlterationPaymentModel")
		public TradeAmendmentContent.TradeAmendmentContentBuilder setTradeAlterationPaymentModel(TradeAlterationPaymentModel tradeAlterationPaymentModel) {
			this.tradeAlterationPaymentModel = tradeAlterationPaymentModel==null?null:tradeAlterationPaymentModel.toBuilder();
			return this;
		}
		
		@Override
		public TradeAmendmentContent build() {
			return new TradeAmendmentContent.TradeAmendmentContentImpl(this);
		}
		
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder prune() {
			super.prune();
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (agreementAndEffectiveDatesModel!=null && !agreementAndEffectiveDatesModel.prune().hasData()) agreementAndEffectiveDatesModel = null;
			if (reportingNotionalChangeModel!=null && !reportingNotionalChangeModel.prune().hasData()) reportingNotionalChangeModel = null;
			if (tradeAlterationPaymentModel!=null && !tradeAlterationPaymentModel.prune().hasData()) tradeAlterationPaymentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getAgreementAndEffectiveDatesModel()!=null && getAgreementAndEffectiveDatesModel().hasData()) return true;
			if (getReportingNotionalChangeModel()!=null && getReportingNotionalChangeModel().hasData()) return true;
			if (getTradeAlterationPaymentModel()!=null && getTradeAlterationPaymentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeAmendmentContent.TradeAmendmentContentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			TradeAmendmentContent.TradeAmendmentContentBuilder o = (TradeAmendmentContent.TradeAmendmentContentBuilder) other;
			
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getAgreementAndEffectiveDatesModel(), o.getAgreementAndEffectiveDatesModel(), this::setAgreementAndEffectiveDatesModel);
			merger.mergeRosetta(getReportingNotionalChangeModel(), o.getReportingNotionalChangeModel(), this::setReportingNotionalChangeModel);
			merger.mergeRosetta(getTradeAlterationPaymentModel(), o.getTradeAlterationPaymentModel(), this::setTradeAlterationPaymentModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			TradeAmendmentContent _that = getType().cast(o);
		
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(agreementAndEffectiveDatesModel, _that.getAgreementAndEffectiveDatesModel())) return false;
			if (!Objects.equals(reportingNotionalChangeModel, _that.getReportingNotionalChangeModel())) return false;
			if (!Objects.equals(tradeAlterationPaymentModel, _that.getTradeAlterationPaymentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (agreementAndEffectiveDatesModel != null ? agreementAndEffectiveDatesModel.hashCode() : 0);
			_result = 31 * _result + (reportingNotionalChangeModel != null ? reportingNotionalChangeModel.hashCode() : 0);
			_result = 31 * _result + (tradeAlterationPaymentModel != null ? tradeAlterationPaymentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeAmendmentContentBuilder {" +
				"trade=" + this.trade + ", " +
				"agreementAndEffectiveDatesModel=" + this.agreementAndEffectiveDatesModel + ", " +
				"reportingNotionalChangeModel=" + this.reportingNotionalChangeModel + ", " +
				"tradeAlterationPaymentModel=" + this.tradeAlterationPaymentModel +
			'}' + " " + super.toString();
		}
	}
}
