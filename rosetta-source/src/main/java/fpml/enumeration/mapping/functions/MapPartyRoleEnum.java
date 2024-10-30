package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.PartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPartyRoleEnum.MapPartyRoleEnumDefault.class)
public abstract class MapPartyRoleEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PartyRoleEnum evaluate(String value) {
		PartyRoleEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PartyRoleEnum doEvaluate(String value);

	public static class MapPartyRoleEnumDefault extends MapPartyRoleEnum {
		@Override
		protected PartyRoleEnum doEvaluate(String value) {
			PartyRoleEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PartyRoleEnum assignOutput(PartyRoleEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Accountant"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.ACCOUNTANT;
			} else if (areEqual(switchArgument, MapperS.of("AllocationAgent"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.ALLOCATION_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("ArrangingBroker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.ARRANGING_BROKER;
			} else if (areEqual(switchArgument, MapperS.of("Beneficiary"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.BENEFICIARY;
			} else if (areEqual(switchArgument, MapperS.of("BookingParty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.BOOKING_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("Buyer"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.BUYER;
			} else if (areEqual(switchArgument, MapperS.of("BuyerDecisionMaker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.BUYER_DECISION_MAKER;
			} else if (areEqual(switchArgument, MapperS.of("ClearingClient"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLEARING_CLIENT;
			} else if (areEqual(switchArgument, MapperS.of("ClearingExceptionParty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLEARING_EXCEPTION_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("ClearingFirm"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLEARING_FIRM;
			} else if (areEqual(switchArgument, MapperS.of("ClearingOrganization"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLEARING_ORGANIZATION;
			} else if (areEqual(switchArgument, MapperS.of("Client"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLIENT;
			} else if (areEqual(switchArgument, MapperS.of("ClientDecisionMaker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CLIENT_DECISION_MAKER;
			} else if (areEqual(switchArgument, MapperS.of("ConfirmationPlatform"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CONFIRMATION_PLATFORM;
			} else if (areEqual(switchArgument, MapperS.of("ConfirmationService"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CONFIRMATION_PLATFORM;
			} else if (areEqual(switchArgument, MapperS.of("ContractualParty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CONTRACTUAL_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("CounterPartyAffiliate"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.COUNTER_PARTY_AFFILIATE;
			} else if (areEqual(switchArgument, MapperS.of("CounterPartyUltimateParent"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.COUNTER_PARTY_ULTIMATE_PARENT;
			} else if (areEqual(switchArgument, MapperS.of("Counterparty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.COUNTERPARTY;
			} else if (areEqual(switchArgument, MapperS.of("CreditSupportProvider"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CREDIT_SUPPORT_PROVIDER;
			} else if (areEqual(switchArgument, MapperS.of("Custodian"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.CUSTODIAN;
			} else if (areEqual(switchArgument, MapperS.of("DataSubmitter"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.DATA_SUBMITTER;
			} else if (areEqual(switchArgument, MapperS.of("DisputingParty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.DISPUTING_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("DocumentRepository"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.DOCUMENT_REPOSITORY;
			} else if (areEqual(switchArgument, MapperS.of("ExecutingBroker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.EXECUTING_BROKER;
			} else if (areEqual(switchArgument, MapperS.of("ExecutingEntity"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.EXECUTING_ENTITY;
			} else if (areEqual(switchArgument, MapperS.of("ExecutionAgent"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.EXECUTION_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("ExecutionFacility"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.EXECUTION_FACILITY;
			} else if (areEqual(switchArgument, MapperS.of("Guarantor"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.GUARANTOR;
			} else if (areEqual(switchArgument, MapperS.of("OrderTransmitter"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.ORDER_TRANSMITTER;
			} else if (areEqual(switchArgument, MapperS.of("PrimeBroker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.PRIME_BROKER;
			} else if (areEqual(switchArgument, MapperS.of("PriorTradeRepository"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.PRIOR_TRADE_REPOSITORY;
			} else if (areEqual(switchArgument, MapperS.of("PTRRCompressionProvider"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.PTRR_SERVICE_PROVIDER;
			} else if (areEqual(switchArgument, MapperS.of("PTRRRebalancingProvider"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.PTRR_SERVICE_PROVIDER;
			} else if (areEqual(switchArgument, MapperS.of("PublicationVenue"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.PUBLICATION_VENUE;
			} else if (areEqual(switchArgument, MapperS.of("ReportingParty"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.REPORTING_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("ReportingPartyAffiliate"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.REPORTING_PARTY_AFFILIATE;
			} else if (areEqual(switchArgument, MapperS.of("ReportingPartyUltimateParent"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.REPORTING_PARTY_ULTIMATE_PARENT;
			} else if (areEqual(switchArgument, MapperS.of("Seller"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.SELLER;
			} else if (areEqual(switchArgument, MapperS.of("SellerDecisionMaker"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.SELLER_DECISION_MAKER;
			} else if (areEqual(switchArgument, MapperS.of("SettlementAgent"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.SETTLEMENT_AGENT;
			} else if (areEqual(switchArgument, MapperS.of("TradeRepository"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.TRADE_REPOSITORY;
			} else if (areEqual(switchArgument, MapperS.of("TradeSource"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.TRADE_SOURCE;
			} else if (areEqual(switchArgument, MapperS.of("TradingManager"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.TRADING_MANAGER;
			} else if (areEqual(switchArgument, MapperS.of("TradingPartner"), CardinalityOperator.All).get()) {
				result = PartyRoleEnum.TRADING_PARTNER;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
