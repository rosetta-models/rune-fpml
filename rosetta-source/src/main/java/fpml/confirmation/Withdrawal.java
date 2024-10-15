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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.ReportingRegimeIdentifier;
import fpml.confirmation.RequestedWithdrawalAction;
import fpml.confirmation.Trade;
import fpml.confirmation.Withdrawal;
import fpml.confirmation.Withdrawal.WithdrawalBuilder;
import fpml.confirmation.Withdrawal.WithdrawalBuilderImpl;
import fpml.confirmation.Withdrawal.WithdrawalImpl;
import fpml.confirmation.WithdrawalReason;
import fpml.confirmation.WithdrawalSequence;
import fpml.confirmation.meta.WithdrawalMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure describing the removal of a trade from a service, such as a reporting service.
 * @version ${project.version}
 */
@RosettaDataType(value="Withdrawal", builder=Withdrawal.WithdrawalBuilderImpl.class, version="${project.version}")
public interface Withdrawal extends RosettaModelObject {

	WithdrawalMeta metaData = new WithdrawalMeta();

	/*********************** Getter Methods  ***********************/
	WithdrawalSequence getWithdrawalSequence();
	/**
	 * The full trade representation that is being withdrawn.
	 */
	Trade getTrade();
	Date getEffectiveDate();
	RequestedWithdrawalAction getRequestedAction();
	List<? extends WithdrawalReason> getReason();
	/**
	 * DEPRECATED. The supervisor/regulator to which this withdrawal applies
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	Withdrawal build();
	
	Withdrawal.WithdrawalBuilder toBuilder();
	
	static Withdrawal.WithdrawalBuilder builder() {
		return new Withdrawal.WithdrawalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Withdrawal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Withdrawal> getType() {
		return Withdrawal.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("withdrawalSequence"), processor, WithdrawalSequence.class, getWithdrawalSequence());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("requestedAction"), processor, RequestedWithdrawalAction.class, getRequestedAction());
		processRosetta(path.newSubPath("reason"), processor, WithdrawalReason.class, getReason());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalBuilder extends Withdrawal, RosettaModelObjectBuilder {
		WithdrawalSequence.WithdrawalSequenceBuilder getOrCreateWithdrawalSequence();
		WithdrawalSequence.WithdrawalSequenceBuilder getWithdrawalSequence();
		Trade.TradeBuilder getOrCreateTrade();
		Trade.TradeBuilder getTrade();
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getOrCreateRequestedAction();
		RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getRequestedAction();
		WithdrawalReason.WithdrawalReasonBuilder getOrCreateReason(int _index);
		List<? extends WithdrawalReason.WithdrawalReasonBuilder> getReason();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int _index);
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		Withdrawal.WithdrawalBuilder setWithdrawalSequence(WithdrawalSequence withdrawalSequence);
		Withdrawal.WithdrawalBuilder setTrade(Trade trade);
		Withdrawal.WithdrawalBuilder setEffectiveDate(Date effectiveDate);
		Withdrawal.WithdrawalBuilder setRequestedAction(RequestedWithdrawalAction requestedAction);
		Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason0);
		Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason1, int _idx);
		Withdrawal.WithdrawalBuilder addReason(List<? extends WithdrawalReason> reason2);
		Withdrawal.WithdrawalBuilder setReason(List<? extends WithdrawalReason> reason3);
		Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime0);
		Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime1, int _idx);
		Withdrawal.WithdrawalBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime2);
		Withdrawal.WithdrawalBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("withdrawalSequence"), processor, WithdrawalSequence.WithdrawalSequenceBuilder.class, getWithdrawalSequence());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("requestedAction"), processor, RequestedWithdrawalAction.RequestedWithdrawalActionBuilder.class, getRequestedAction());
			processRosetta(path.newSubPath("reason"), processor, WithdrawalReason.WithdrawalReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		Withdrawal.WithdrawalBuilder prune();
	}

	/*********************** Immutable Implementation of Withdrawal  ***********************/
	class WithdrawalImpl implements Withdrawal {
		private final WithdrawalSequence withdrawalSequence;
		private final Trade trade;
		private final Date effectiveDate;
		private final RequestedWithdrawalAction requestedAction;
		private final List<? extends WithdrawalReason> reason;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected WithdrawalImpl(Withdrawal.WithdrawalBuilder builder) {
			this.withdrawalSequence = ofNullable(builder.getWithdrawalSequence()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.effectiveDate = builder.getEffectiveDate();
			this.requestedAction = ofNullable(builder.getRequestedAction()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("withdrawalSequence")
		public WithdrawalSequence getWithdrawalSequence() {
			return withdrawalSequence;
		}
		
		@Override
		@RosettaAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedWithdrawalAction getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends WithdrawalReason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public Withdrawal build() {
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder toBuilder() {
			Withdrawal.WithdrawalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Withdrawal.WithdrawalBuilder builder) {
			ofNullable(getWithdrawalSequence()).ifPresent(builder::setWithdrawalSequence);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getRequestedAction()).ifPresent(builder::setRequestedAction);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Withdrawal _that = getType().cast(o);
		
			if (!Objects.equals(withdrawalSequence, _that.getWithdrawalSequence())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (withdrawalSequence != null ? withdrawalSequence.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Withdrawal {" +
				"withdrawalSequence=" + this.withdrawalSequence + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"reason=" + this.reason + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of Withdrawal  ***********************/
	class WithdrawalBuilderImpl implements Withdrawal.WithdrawalBuilder {
	
		protected WithdrawalSequence.WithdrawalSequenceBuilder withdrawalSequence;
		protected Trade.TradeBuilder trade;
		protected Date effectiveDate;
		protected RequestedWithdrawalAction.RequestedWithdrawalActionBuilder requestedAction;
		protected List<WithdrawalReason.WithdrawalReasonBuilder> reason = new ArrayList<>();
		protected List<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> reportingRegime = new ArrayList<>();
	
		public WithdrawalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("withdrawalSequence")
		public WithdrawalSequence.WithdrawalSequenceBuilder getWithdrawalSequence() {
			return withdrawalSequence;
		}
		
		@Override
		public WithdrawalSequence.WithdrawalSequenceBuilder getOrCreateWithdrawalSequence() {
			WithdrawalSequence.WithdrawalSequenceBuilder result;
			if (withdrawalSequence!=null) {
				result = withdrawalSequence;
			}
			else {
				result = withdrawalSequence = WithdrawalSequence.builder();
			}
			
			return result;
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
		@RosettaAttribute("effectiveDate")
		public Date getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		public RequestedWithdrawalAction.RequestedWithdrawalActionBuilder getOrCreateRequestedAction() {
			RequestedWithdrawalAction.RequestedWithdrawalActionBuilder result;
			if (requestedAction!=null) {
				result = requestedAction;
			}
			else {
				result = requestedAction = RequestedWithdrawalAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends WithdrawalReason.WithdrawalReasonBuilder> getReason() {
			return reason;
		}
		
		public WithdrawalReason.WithdrawalReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			WithdrawalReason.WithdrawalReasonBuilder result;
			return getIndex(reason, _index, () -> {
						WithdrawalReason.WithdrawalReasonBuilder newReason = WithdrawalReason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int _index) {
		
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder result;
			return getIndex(reportingRegime, _index, () -> {
						ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder newReportingRegime = ReportingRegimeIdentifier.builder();
						return newReportingRegime;
					});
		}
		
		@Override
		@RosettaAttribute("withdrawalSequence")
		public Withdrawal.WithdrawalBuilder setWithdrawalSequence(WithdrawalSequence withdrawalSequence) {
			this.withdrawalSequence = withdrawalSequence==null?null:withdrawalSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trade")
		public Withdrawal.WithdrawalBuilder setTrade(Trade trade) {
			this.trade = trade==null?null:trade.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public Withdrawal.WithdrawalBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("requestedAction")
		public Withdrawal.WithdrawalBuilder setRequestedAction(RequestedWithdrawalAction requestedAction) {
			this.requestedAction = requestedAction==null?null:requestedAction.toBuilder();
			return this;
		}
		@Override
		public Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReason(WithdrawalReason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public Withdrawal.WithdrawalBuilder addReason(List<? extends WithdrawalReason> reasons) {
			if (reasons != null) {
				for (WithdrawalReason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public Withdrawal.WithdrawalBuilder setReason(List<? extends WithdrawalReason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime) {
			if (reportingRegime!=null) this.reportingRegime.add(reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int _idx) {
			getIndex(this.reportingRegime, _idx, () -> reportingRegime.toBuilder());
			return this;
		}
		@Override 
		public Withdrawal.WithdrawalBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes != null) {
				for (ReportingRegimeIdentifier toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reportingRegime")
		public Withdrawal.WithdrawalBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes == null)  {
				this.reportingRegime = new ArrayList<>();
			}
			else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Withdrawal build() {
			return new Withdrawal.WithdrawalImpl(this);
		}
		
		@Override
		public Withdrawal.WithdrawalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Withdrawal.WithdrawalBuilder prune() {
			if (withdrawalSequence!=null && !withdrawalSequence.prune().hasData()) withdrawalSequence = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (requestedAction!=null && !requestedAction.prune().hasData()) requestedAction = null;
			reason = reason.stream().filter(b->b!=null).<WithdrawalReason.WithdrawalReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getWithdrawalSequence()!=null && getWithdrawalSequence().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getEffectiveDate()!=null) return true;
			if (getRequestedAction()!=null && getRequestedAction().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Withdrawal.WithdrawalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Withdrawal.WithdrawalBuilder o = (Withdrawal.WithdrawalBuilder) other;
			
			merger.mergeRosetta(getWithdrawalSequence(), o.getWithdrawalSequence(), this::setWithdrawalSequence);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getRequestedAction(), o.getRequestedAction(), this::setRequestedAction);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			merger.mergeBasic(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Withdrawal _that = getType().cast(o);
		
			if (!Objects.equals(withdrawalSequence, _that.getWithdrawalSequence())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (withdrawalSequence != null ? withdrawalSequence.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalBuilder {" +
				"withdrawalSequence=" + this.withdrawalSequence + ", " +
				"trade=" + this.trade + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"reason=" + this.reason + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
