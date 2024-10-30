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
import fpml.confirmation.Allocations;
import fpml.confirmation.Approvals;
import fpml.confirmation.CalculationAgentModel;
import fpml.confirmation.Collateral;
import fpml.confirmation.Documentation;
import fpml.confirmation.GoverningLaw;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Trade;
import fpml.confirmation.Trade.TradeBuilder;
import fpml.confirmation.Trade.TradeBuilderImpl;
import fpml.confirmation.Trade.TradeImpl;
import fpml.confirmation.TradeHeader;
import fpml.confirmation.meta.TradeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining an FpML trade.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Trade", builder=Trade.TradeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Trade extends RosettaModelObject {

	TradeMeta metaData = new TradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The information on the trade which is not product specific, e.g. trade date.
	 */
	TradeHeader getTradeHeader();
	Product getProduct();
	/**
	 * Other fees or additional payments associated with the trade, e.g. broker commissions, where one or more of the parties involved are not principal parties involved in the trade.
	 */
	List<? extends Payment> getOtherPartyPayment();
	/**
	 * Identifies that party (or parties) that brokered this trade.
	 */
	List<? extends PartyReference> getBrokerPartyReference();
	CalculationAgentModel getCalculationAgentModel();
	/**
	 * The party referenced is the ISDA Determination Party that specified in the related Confirmation as Determination Party.
	 */
	List<? extends PartyReference> getDeterminingParty();
	/**
	 * The party referenced is specified in the related Confirmation as Barrier Determination Agent.
	 */
	PartyReference getBarrierDeterminationAgent();
	/**
	 * The party referenced is the ISDA Hedging Party that specified in the related Confirmation as Hedging, or if no Hedging Party is specified, either party to the Transaction.
	 */
	List<? extends PartyReference> getHedgingParty();
	/**
	 * Defines collateral obiligations of a Party
	 */
	Collateral getCollateral();
	/**
	 * Defines the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
	 */
	Documentation getDocumentation();
	/**
	 * Identification of the law governing the transaction.
	 */
	GoverningLaw getGoverningLaw();
	/**
	 * &quot;Short-form&quot; representation of allocations in which the key block economics are stated once within the trade structure, and the allocation data is contained in this allocations structure.
	 */
	List<? extends Allocations> getAllocations();
	/**
	 * A container for approval states in the workflow.
	 */
	Approvals getApprovals();
	String getId();

	/*********************** Build Methods  ***********************/
	Trade build();
	
	Trade.TradeBuilder toBuilder();
	
	static Trade.TradeBuilder builder() {
		return new Trade.TradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trade> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Trade> getType() {
		return Trade.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeHeader"), processor, TradeHeader.class, getTradeHeader());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("otherPartyPayment"), processor, Payment.class, getOtherPartyPayment());
		processRosetta(path.newSubPath("brokerPartyReference"), processor, PartyReference.class, getBrokerPartyReference());
		processRosetta(path.newSubPath("calculationAgentModel"), processor, CalculationAgentModel.class, getCalculationAgentModel());
		processRosetta(path.newSubPath("determiningParty"), processor, PartyReference.class, getDeterminingParty());
		processRosetta(path.newSubPath("barrierDeterminationAgent"), processor, PartyReference.class, getBarrierDeterminationAgent());
		processRosetta(path.newSubPath("hedgingParty"), processor, PartyReference.class, getHedgingParty());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("documentation"), processor, Documentation.class, getDocumentation());
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeBuilder extends Trade, RosettaModelObjectBuilder {
		TradeHeader.TradeHeaderBuilder getOrCreateTradeHeader();
		TradeHeader.TradeHeaderBuilder getTradeHeader();
		Product.ProductBuilder getOrCreateProduct();
		Product.ProductBuilder getProduct();
		Payment.PaymentBuilder getOrCreateOtherPartyPayment(int _index);
		List<? extends Payment.PaymentBuilder> getOtherPartyPayment();
		PartyReference.PartyReferenceBuilder getOrCreateBrokerPartyReference(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getBrokerPartyReference();
		CalculationAgentModel.CalculationAgentModelBuilder getOrCreateCalculationAgentModel();
		CalculationAgentModel.CalculationAgentModelBuilder getCalculationAgentModel();
		PartyReference.PartyReferenceBuilder getOrCreateDeterminingParty(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getDeterminingParty();
		PartyReference.PartyReferenceBuilder getOrCreateBarrierDeterminationAgent();
		PartyReference.PartyReferenceBuilder getBarrierDeterminationAgent();
		PartyReference.PartyReferenceBuilder getOrCreateHedgingParty(int _index);
		List<? extends PartyReference.PartyReferenceBuilder> getHedgingParty();
		Collateral.CollateralBuilder getOrCreateCollateral();
		Collateral.CollateralBuilder getCollateral();
		Documentation.DocumentationBuilder getOrCreateDocumentation();
		Documentation.DocumentationBuilder getDocumentation();
		GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw();
		GoverningLaw.GoverningLawBuilder getGoverningLaw();
		Allocations.AllocationsBuilder getOrCreateAllocations(int _index);
		List<? extends Allocations.AllocationsBuilder> getAllocations();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		Approvals.ApprovalsBuilder getApprovals();
		Trade.TradeBuilder setTradeHeader(TradeHeader tradeHeader);
		Trade.TradeBuilder setProduct(Product product);
		Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment0);
		Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment1, int _idx);
		Trade.TradeBuilder addOtherPartyPayment(List<? extends Payment> otherPartyPayment2);
		Trade.TradeBuilder setOtherPartyPayment(List<? extends Payment> otherPartyPayment3);
		Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference0);
		Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference1, int _idx);
		Trade.TradeBuilder addBrokerPartyReference(List<? extends PartyReference> brokerPartyReference2);
		Trade.TradeBuilder setBrokerPartyReference(List<? extends PartyReference> brokerPartyReference3);
		Trade.TradeBuilder setCalculationAgentModel(CalculationAgentModel calculationAgentModel);
		Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty0);
		Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty1, int _idx);
		Trade.TradeBuilder addDeterminingParty(List<? extends PartyReference> determiningParty2);
		Trade.TradeBuilder setDeterminingParty(List<? extends PartyReference> determiningParty3);
		Trade.TradeBuilder setBarrierDeterminationAgent(PartyReference barrierDeterminationAgent);
		Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty0);
		Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty1, int _idx);
		Trade.TradeBuilder addHedgingParty(List<? extends PartyReference> hedgingParty2);
		Trade.TradeBuilder setHedgingParty(List<? extends PartyReference> hedgingParty3);
		Trade.TradeBuilder setCollateral(Collateral collateral);
		Trade.TradeBuilder setDocumentation(Documentation documentation);
		Trade.TradeBuilder setGoverningLaw(GoverningLaw governingLaw);
		Trade.TradeBuilder addAllocations(Allocations allocations0);
		Trade.TradeBuilder addAllocations(Allocations allocations1, int _idx);
		Trade.TradeBuilder addAllocations(List<? extends Allocations> allocations2);
		Trade.TradeBuilder setAllocations(List<? extends Allocations> allocations3);
		Trade.TradeBuilder setApprovals(Approvals approvals);
		Trade.TradeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeHeader"), processor, TradeHeader.TradeHeaderBuilder.class, getTradeHeader());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("otherPartyPayment"), processor, Payment.PaymentBuilder.class, getOtherPartyPayment());
			processRosetta(path.newSubPath("brokerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBrokerPartyReference());
			processRosetta(path.newSubPath("calculationAgentModel"), processor, CalculationAgentModel.CalculationAgentModelBuilder.class, getCalculationAgentModel());
			processRosetta(path.newSubPath("determiningParty"), processor, PartyReference.PartyReferenceBuilder.class, getDeterminingParty());
			processRosetta(path.newSubPath("barrierDeterminationAgent"), processor, PartyReference.PartyReferenceBuilder.class, getBarrierDeterminationAgent());
			processRosetta(path.newSubPath("hedgingParty"), processor, PartyReference.PartyReferenceBuilder.class, getHedgingParty());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("documentation"), processor, Documentation.DocumentationBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Trade.TradeBuilder prune();
	}

	/*********************** Immutable Implementation of Trade  ***********************/
	class TradeImpl implements Trade {
		private final TradeHeader tradeHeader;
		private final Product product;
		private final List<? extends Payment> otherPartyPayment;
		private final List<? extends PartyReference> brokerPartyReference;
		private final CalculationAgentModel calculationAgentModel;
		private final List<? extends PartyReference> determiningParty;
		private final PartyReference barrierDeterminationAgent;
		private final List<? extends PartyReference> hedgingParty;
		private final Collateral collateral;
		private final Documentation documentation;
		private final GoverningLaw governingLaw;
		private final List<? extends Allocations> allocations;
		private final Approvals approvals;
		private final String id;
		
		protected TradeImpl(Trade.TradeBuilder builder) {
			this.tradeHeader = ofNullable(builder.getTradeHeader()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
			this.otherPartyPayment = ofNullable(builder.getOtherPartyPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.brokerPartyReference = ofNullable(builder.getBrokerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationAgentModel = ofNullable(builder.getCalculationAgentModel()).map(f->f.build()).orElse(null);
			this.determiningParty = ofNullable(builder.getDeterminingParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrierDeterminationAgent = ofNullable(builder.getBarrierDeterminationAgent()).map(f->f.build()).orElse(null);
			this.hedgingParty = ofNullable(builder.getHedgingParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.documentation = ofNullable(builder.getDocumentation()).map(f->f.build()).orElse(null);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("tradeHeader")
		public TradeHeader getTradeHeader() {
			return tradeHeader;
		}
		
		@Override
		@RosettaAttribute("product")
		public Product getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("otherPartyPayment")
		public List<? extends Payment> getOtherPartyPayment() {
			return otherPartyPayment;
		}
		
		@Override
		@RosettaAttribute("brokerPartyReference")
		public List<? extends PartyReference> getBrokerPartyReference() {
			return brokerPartyReference;
		}
		
		@Override
		@RosettaAttribute("calculationAgentModel")
		public CalculationAgentModel getCalculationAgentModel() {
			return calculationAgentModel;
		}
		
		@Override
		@RosettaAttribute("determiningParty")
		public List<? extends PartyReference> getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		@RosettaAttribute("barrierDeterminationAgent")
		public PartyReference getBarrierDeterminationAgent() {
			return barrierDeterminationAgent;
		}
		
		@Override
		@RosettaAttribute("hedgingParty")
		public List<? extends PartyReference> getHedgingParty() {
			return hedgingParty;
		}
		
		@Override
		@RosettaAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("documentation")
		public Documentation getDocumentation() {
			return documentation;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		public GoverningLaw getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public List<? extends Allocations> getAllocations() {
			return allocations;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Trade build() {
			return this;
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			Trade.TradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trade.TradeBuilder builder) {
			ofNullable(getTradeHeader()).ifPresent(builder::setTradeHeader);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getOtherPartyPayment()).ifPresent(builder::setOtherPartyPayment);
			ofNullable(getBrokerPartyReference()).ifPresent(builder::setBrokerPartyReference);
			ofNullable(getCalculationAgentModel()).ifPresent(builder::setCalculationAgentModel);
			ofNullable(getDeterminingParty()).ifPresent(builder::setDeterminingParty);
			ofNullable(getBarrierDeterminationAgent()).ifPresent(builder::setBarrierDeterminationAgent);
			ofNullable(getHedgingParty()).ifPresent(builder::setHedgingParty);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!Objects.equals(tradeHeader, _that.getTradeHeader())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(otherPartyPayment, _that.getOtherPartyPayment())) return false;
			if (!ListEquals.listEquals(brokerPartyReference, _that.getBrokerPartyReference())) return false;
			if (!Objects.equals(calculationAgentModel, _that.getCalculationAgentModel())) return false;
			if (!ListEquals.listEquals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(barrierDeterminationAgent, _that.getBarrierDeterminationAgent())) return false;
			if (!ListEquals.listEquals(hedgingParty, _that.getHedgingParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeHeader != null ? tradeHeader.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (otherPartyPayment != null ? otherPartyPayment.hashCode() : 0);
			_result = 31 * _result + (brokerPartyReference != null ? brokerPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgentModel != null ? calculationAgentModel.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.hashCode() : 0);
			_result = 31 * _result + (barrierDeterminationAgent != null ? barrierDeterminationAgent.hashCode() : 0);
			_result = 31 * _result + (hedgingParty != null ? hedgingParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trade {" +
				"tradeHeader=" + this.tradeHeader + ", " +
				"product=" + this.product + ", " +
				"otherPartyPayment=" + this.otherPartyPayment + ", " +
				"brokerPartyReference=" + this.brokerPartyReference + ", " +
				"calculationAgentModel=" + this.calculationAgentModel + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"barrierDeterminationAgent=" + this.barrierDeterminationAgent + ", " +
				"hedgingParty=" + this.hedgingParty + ", " +
				"collateral=" + this.collateral + ", " +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"allocations=" + this.allocations + ", " +
				"approvals=" + this.approvals + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Trade  ***********************/
	class TradeBuilderImpl implements Trade.TradeBuilder {
	
		protected TradeHeader.TradeHeaderBuilder tradeHeader;
		protected Product.ProductBuilder product;
		protected List<Payment.PaymentBuilder> otherPartyPayment = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> brokerPartyReference = new ArrayList<>();
		protected CalculationAgentModel.CalculationAgentModelBuilder calculationAgentModel;
		protected List<PartyReference.PartyReferenceBuilder> determiningParty = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder barrierDeterminationAgent;
		protected List<PartyReference.PartyReferenceBuilder> hedgingParty = new ArrayList<>();
		protected Collateral.CollateralBuilder collateral;
		protected Documentation.DocumentationBuilder documentation;
		protected GoverningLaw.GoverningLawBuilder governingLaw;
		protected List<Allocations.AllocationsBuilder> allocations = new ArrayList<>();
		protected Approvals.ApprovalsBuilder approvals;
		protected String id;
	
		public TradeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeHeader")
		public TradeHeader.TradeHeaderBuilder getTradeHeader() {
			return tradeHeader;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder getOrCreateTradeHeader() {
			TradeHeader.TradeHeaderBuilder result;
			if (tradeHeader!=null) {
				result = tradeHeader;
			}
			else {
				result = tradeHeader = TradeHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherPartyPayment")
		public List<? extends Payment.PaymentBuilder> getOtherPartyPayment() {
			return otherPartyPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateOtherPartyPayment(int _index) {
		
			if (otherPartyPayment==null) {
				this.otherPartyPayment = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(otherPartyPayment, _index, () -> {
						Payment.PaymentBuilder newOtherPartyPayment = Payment.builder();
						return newOtherPartyPayment;
					});
		}
		
		@Override
		@RosettaAttribute("brokerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getBrokerPartyReference() {
			return brokerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBrokerPartyReference(int _index) {
		
			if (brokerPartyReference==null) {
				this.brokerPartyReference = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(brokerPartyReference, _index, () -> {
						PartyReference.PartyReferenceBuilder newBrokerPartyReference = PartyReference.builder();
						return newBrokerPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationAgentModel")
		public CalculationAgentModel.CalculationAgentModelBuilder getCalculationAgentModel() {
			return calculationAgentModel;
		}
		
		@Override
		public CalculationAgentModel.CalculationAgentModelBuilder getOrCreateCalculationAgentModel() {
			CalculationAgentModel.CalculationAgentModelBuilder result;
			if (calculationAgentModel!=null) {
				result = calculationAgentModel;
			}
			else {
				result = calculationAgentModel = CalculationAgentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determiningParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDeterminingParty(int _index) {
		
			if (determiningParty==null) {
				this.determiningParty = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(determiningParty, _index, () -> {
						PartyReference.PartyReferenceBuilder newDeterminingParty = PartyReference.builder();
						return newDeterminingParty;
					});
		}
		
		@Override
		@RosettaAttribute("barrierDeterminationAgent")
		public PartyReference.PartyReferenceBuilder getBarrierDeterminationAgent() {
			return barrierDeterminationAgent;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBarrierDeterminationAgent() {
			PartyReference.PartyReferenceBuilder result;
			if (barrierDeterminationAgent!=null) {
				result = barrierDeterminationAgent;
			}
			else {
				result = barrierDeterminationAgent = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hedgingParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getHedgingParty() {
			return hedgingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateHedgingParty(int _index) {
		
			if (hedgingParty==null) {
				this.hedgingParty = new ArrayList<>();
			}
			PartyReference.PartyReferenceBuilder result;
			return getIndex(hedgingParty, _index, () -> {
						PartyReference.PartyReferenceBuilder newHedgingParty = PartyReference.builder();
						return newHedgingParty;
					});
		}
		
		@Override
		@RosettaAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("documentation")
		public Documentation.DocumentationBuilder getDocumentation() {
			return documentation;
		}
		
		@Override
		public Documentation.DocumentationBuilder getOrCreateDocumentation() {
			Documentation.DocumentationBuilder result;
			if (documentation!=null) {
				result = documentation;
			}
			else {
				result = documentation = Documentation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		public GoverningLaw.GoverningLawBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw() {
			GoverningLaw.GoverningLawBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = GoverningLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public List<? extends Allocations.AllocationsBuilder> getAllocations() {
			return allocations;
		}
		
		@Override
		public Allocations.AllocationsBuilder getOrCreateAllocations(int _index) {
		
			if (allocations==null) {
				this.allocations = new ArrayList<>();
			}
			Allocations.AllocationsBuilder result;
			return getIndex(allocations, _index, () -> {
						Allocations.AllocationsBuilder newAllocations = Allocations.builder();
						return newAllocations;
					});
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("tradeHeader")
		public Trade.TradeBuilder setTradeHeader(TradeHeader tradeHeader) {
			this.tradeHeader = tradeHeader==null?null:tradeHeader.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("product")
		public Trade.TradeBuilder setProduct(Product product) {
			this.product = product==null?null:product.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("otherPartyPayment")
		public Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment) {
			if (otherPartyPayment!=null) this.otherPartyPayment.add(otherPartyPayment.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment, int _idx) {
			getIndex(this.otherPartyPayment, _idx, () -> otherPartyPayment.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addOtherPartyPayment(List<? extends Payment> otherPartyPayments) {
			if (otherPartyPayments != null) {
				for (Payment toAdd : otherPartyPayments) {
					this.otherPartyPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setOtherPartyPayment(List<? extends Payment> otherPartyPayments) {
			if (otherPartyPayments == null)  {
				this.otherPartyPayment = new ArrayList<>();
			}
			else {
				this.otherPartyPayment = otherPartyPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("brokerPartyReference")
		public Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference) {
			if (brokerPartyReference!=null) this.brokerPartyReference.add(brokerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference, int _idx) {
			getIndex(this.brokerPartyReference, _idx, () -> brokerPartyReference.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addBrokerPartyReference(List<? extends PartyReference> brokerPartyReferences) {
			if (brokerPartyReferences != null) {
				for (PartyReference toAdd : brokerPartyReferences) {
					this.brokerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setBrokerPartyReference(List<? extends PartyReference> brokerPartyReferences) {
			if (brokerPartyReferences == null)  {
				this.brokerPartyReference = new ArrayList<>();
			}
			else {
				this.brokerPartyReference = brokerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("calculationAgentModel")
		public Trade.TradeBuilder setCalculationAgentModel(CalculationAgentModel calculationAgentModel) {
			this.calculationAgentModel = calculationAgentModel==null?null:calculationAgentModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("determiningParty")
		public Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty) {
			if (determiningParty!=null) this.determiningParty.add(determiningParty.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty, int _idx) {
			getIndex(this.determiningParty, _idx, () -> determiningParty.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addDeterminingParty(List<? extends PartyReference> determiningPartys) {
			if (determiningPartys != null) {
				for (PartyReference toAdd : determiningPartys) {
					this.determiningParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setDeterminingParty(List<? extends PartyReference> determiningPartys) {
			if (determiningPartys == null)  {
				this.determiningParty = new ArrayList<>();
			}
			else {
				this.determiningParty = determiningPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("barrierDeterminationAgent")
		public Trade.TradeBuilder setBarrierDeterminationAgent(PartyReference barrierDeterminationAgent) {
			this.barrierDeterminationAgent = barrierDeterminationAgent==null?null:barrierDeterminationAgent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("hedgingParty")
		public Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty) {
			if (hedgingParty!=null) this.hedgingParty.add(hedgingParty.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty, int _idx) {
			getIndex(this.hedgingParty, _idx, () -> hedgingParty.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addHedgingParty(List<? extends PartyReference> hedgingPartys) {
			if (hedgingPartys != null) {
				for (PartyReference toAdd : hedgingPartys) {
					this.hedgingParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setHedgingParty(List<? extends PartyReference> hedgingPartys) {
			if (hedgingPartys == null)  {
				this.hedgingParty = new ArrayList<>();
			}
			else {
				this.hedgingParty = hedgingPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("collateral")
		public Trade.TradeBuilder setCollateral(Collateral collateral) {
			this.collateral = collateral==null?null:collateral.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("documentation")
		public Trade.TradeBuilder setDocumentation(Documentation documentation) {
			this.documentation = documentation==null?null:documentation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("governingLaw")
		public Trade.TradeBuilder setGoverningLaw(GoverningLaw governingLaw) {
			this.governingLaw = governingLaw==null?null:governingLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocations")
		public Trade.TradeBuilder addAllocations(Allocations allocations) {
			if (allocations!=null) this.allocations.add(allocations.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addAllocations(Allocations allocations, int _idx) {
			getIndex(this.allocations, _idx, () -> allocations.toBuilder());
			return this;
		}
		@Override 
		public Trade.TradeBuilder addAllocations(List<? extends Allocations> allocationss) {
			if (allocationss != null) {
				for (Allocations toAdd : allocationss) {
					this.allocations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Trade.TradeBuilder setAllocations(List<? extends Allocations> allocationss) {
			if (allocationss == null)  {
				this.allocations = new ArrayList<>();
			}
			else {
				this.allocations = allocationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("approvals")
		public Trade.TradeBuilder setApprovals(Approvals approvals) {
			this.approvals = approvals==null?null:approvals.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Trade.TradeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Trade build() {
			return new Trade.TradeImpl(this);
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder prune() {
			if (tradeHeader!=null && !tradeHeader.prune().hasData()) tradeHeader = null;
			if (product!=null && !product.prune().hasData()) product = null;
			otherPartyPayment = otherPartyPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			brokerPartyReference = brokerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationAgentModel!=null && !calculationAgentModel.prune().hasData()) calculationAgentModel = null;
			determiningParty = determiningParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (barrierDeterminationAgent!=null && !barrierDeterminationAgent.prune().hasData()) barrierDeterminationAgent = null;
			hedgingParty = hedgingParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (documentation!=null && !documentation.prune().hasData()) documentation = null;
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			allocations = allocations.stream().filter(b->b!=null).<Allocations.AllocationsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeHeader()!=null && getTradeHeader().hasData()) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			if (getOtherPartyPayment()!=null && getOtherPartyPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBrokerPartyReference()!=null && getBrokerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationAgentModel()!=null && getCalculationAgentModel().hasData()) return true;
			if (getDeterminingParty()!=null && getDeterminingParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrierDeterminationAgent()!=null && getBarrierDeterminationAgent().hasData()) return true;
			if (getHedgingParty()!=null && getHedgingParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getDocumentation()!=null && getDocumentation().hasData()) return true;
			if (getGoverningLaw()!=null && getGoverningLaw().hasData()) return true;
			if (getAllocations()!=null && getAllocations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trade.TradeBuilder o = (Trade.TradeBuilder) other;
			
			merger.mergeRosetta(getTradeHeader(), o.getTradeHeader(), this::setTradeHeader);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			merger.mergeRosetta(getOtherPartyPayment(), o.getOtherPartyPayment(), this::getOrCreateOtherPartyPayment);
			merger.mergeRosetta(getBrokerPartyReference(), o.getBrokerPartyReference(), this::getOrCreateBrokerPartyReference);
			merger.mergeRosetta(getCalculationAgentModel(), o.getCalculationAgentModel(), this::setCalculationAgentModel);
			merger.mergeRosetta(getDeterminingParty(), o.getDeterminingParty(), this::getOrCreateDeterminingParty);
			merger.mergeRosetta(getBarrierDeterminationAgent(), o.getBarrierDeterminationAgent(), this::setBarrierDeterminationAgent);
			merger.mergeRosetta(getHedgingParty(), o.getHedgingParty(), this::getOrCreateHedgingParty);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::setDocumentation);
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::getOrCreateAllocations);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!Objects.equals(tradeHeader, _that.getTradeHeader())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(otherPartyPayment, _that.getOtherPartyPayment())) return false;
			if (!ListEquals.listEquals(brokerPartyReference, _that.getBrokerPartyReference())) return false;
			if (!Objects.equals(calculationAgentModel, _that.getCalculationAgentModel())) return false;
			if (!ListEquals.listEquals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(barrierDeterminationAgent, _that.getBarrierDeterminationAgent())) return false;
			if (!ListEquals.listEquals(hedgingParty, _that.getHedgingParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeHeader != null ? tradeHeader.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (otherPartyPayment != null ? otherPartyPayment.hashCode() : 0);
			_result = 31 * _result + (brokerPartyReference != null ? brokerPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgentModel != null ? calculationAgentModel.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.hashCode() : 0);
			_result = 31 * _result + (barrierDeterminationAgent != null ? barrierDeterminationAgent.hashCode() : 0);
			_result = 31 * _result + (hedgingParty != null ? hedgingParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeBuilder {" +
				"tradeHeader=" + this.tradeHeader + ", " +
				"product=" + this.product + ", " +
				"otherPartyPayment=" + this.otherPartyPayment + ", " +
				"brokerPartyReference=" + this.brokerPartyReference + ", " +
				"calculationAgentModel=" + this.calculationAgentModel + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"barrierDeterminationAgent=" + this.barrierDeterminationAgent + ", " +
				"hedgingParty=" + this.hedgingParty + ", " +
				"collateral=" + this.collateral + ", " +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"allocations=" + this.allocations + ", " +
				"approvals=" + this.approvals + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
