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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.EquitySwapTransactionSupplement;
import fpml.confirmation.EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder;
import fpml.confirmation.EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl;
import fpml.confirmation.EquitySwapTransactionSupplement.EquitySwapTransactionSupplementImpl;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.ReturnSwapBase;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilder;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilderImpl;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseImpl;
import fpml.confirmation.meta.EquitySwapTransactionSupplementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of the equity swap transaction supplement. A type for defining Equity Swap Transaction Supplement
 * @version ${project.version}
 */
@RosettaDataType(value="EquitySwapTransactionSupplement", builder=EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface EquitySwapTransactionSupplement extends ReturnSwapBase {

	EquitySwapTransactionSupplementMeta metaData = new EquitySwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	MutualOrOptionalEarlyTerminationModel getMutualOrOptionalEarlyTerminationModel();
	EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel();
	/**
	 * Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	EquitySwapTransactionSupplement build();
	
	EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder();
	
	static EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder() {
		return new EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquitySwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquitySwapTransactionSupplement> getType() {
		return EquitySwapTransactionSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.class, getReturnSwapLeg());
		processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.class, getPrincipalExchangeFeatures());
		processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModel"), processor, MutualOrOptionalEarlyTerminationModel.class, getMutualOrOptionalEarlyTerminationModel());
		processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.class, getEquityUnderlyerProvisionsModel());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquitySwapTransactionSupplementBuilder extends EquitySwapTransactionSupplement, ReturnSwapBase.ReturnSwapBaseBuilder {
		MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder getOrCreateMutualOrOptionalEarlyTerminationModel();
		MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder getMutualOrOptionalEarlyTerminationModel();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductModel(ProductModel productModel);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setId(String id);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg0);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg1, int _idx);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg2);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg3);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment0);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment1, int _idx);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment2);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment3);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMutualOrOptionalEarlyTerminationModel(MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel);
		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.DirectionalLegBuilder.class, getReturnSwapLeg());
			processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder.class, getPrincipalExchangeFeatures());
			processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("mutualOrOptionalEarlyTerminationModel"), processor, MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder.class, getMutualOrOptionalEarlyTerminationModel());
			processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder.class, getEquityUnderlyerProvisionsModel());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of EquitySwapTransactionSupplement  ***********************/
	class EquitySwapTransactionSupplementImpl extends ReturnSwapBase.ReturnSwapBaseImpl implements EquitySwapTransactionSupplement {
		private final MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel;
		private final EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected EquitySwapTransactionSupplementImpl(EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder) {
			super(builder);
			this.mutualOrOptionalEarlyTerminationModel = ofNullable(builder.getMutualOrOptionalEarlyTerminationModel()).map(f->f.build()).orElse(null);
			this.equityUnderlyerProvisionsModel = ofNullable(builder.getEquityUnderlyerProvisionsModel()).map(f->f.build()).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModel")
		public MutualOrOptionalEarlyTerminationModel getMutualOrOptionalEarlyTerminationModel() {
			return mutualOrOptionalEarlyTerminationModel;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public EquitySwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder() {
			EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMutualOrOptionalEarlyTerminationModel()).ifPresent(builder::setMutualOrOptionalEarlyTerminationModel);
			ofNullable(getEquityUnderlyerProvisionsModel()).ifPresent(builder::setEquityUnderlyerProvisionsModel);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModel, _that.getMutualOrOptionalEarlyTerminationModel())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModel != null ? mutualOrOptionalEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapTransactionSupplement {" +
				"mutualOrOptionalEarlyTerminationModel=" + this.mutualOrOptionalEarlyTerminationModel + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EquitySwapTransactionSupplement  ***********************/
	class EquitySwapTransactionSupplementBuilderImpl extends ReturnSwapBase.ReturnSwapBaseBuilderImpl  implements EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder {
	
		protected MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder mutualOrOptionalEarlyTerminationModel;
		protected EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder equityUnderlyerProvisionsModel;
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
	
		public EquitySwapTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModel")
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder getMutualOrOptionalEarlyTerminationModel() {
			return mutualOrOptionalEarlyTerminationModel;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder getOrCreateMutualOrOptionalEarlyTerminationModel() {
			MutualOrOptionalEarlyTerminationModel.MutualOrOptionalEarlyTerminationModelBuilder result;
			if (mutualOrOptionalEarlyTerminationModel!=null) {
				result = mutualOrOptionalEarlyTerminationModel;
			}
			else {
				result = mutualOrOptionalEarlyTerminationModel = MutualOrOptionalEarlyTerminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel() {
			EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder result;
			if (equityUnderlyerProvisionsModel!=null) {
				result = equityUnderlyerProvisionsModel;
			}
			else {
				result = equityUnderlyerProvisionsModel = EquityUnderlyerProvisionsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder result;
			if (extraordinaryEvents!=null) {
				result = extraordinaryEvents;
			}
			else {
				result = extraordinaryEvents = ExtraordinaryEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg) {
			if (returnSwapLeg!=null) this.returnSwapLeg.add(returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int _idx) {
			getIndex(this.returnSwapLeg, _idx, () -> returnSwapLeg.toBuilder());
			return this;
		}
		@Override 
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs != null) {
				for (DirectionalLeg toAdd : returnSwapLegs) {
					this.returnSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("returnSwapLeg")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs == null)  {
				this.returnSwapLeg = new ArrayList<>();
			}
			else {
				this.returnSwapLeg = returnSwapLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("principalExchangeFeatures")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures) {
			this.principalExchangeFeatures = principalExchangeFeatures==null?null:principalExchangeFeatures.toBuilder();
			return this;
		}
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ReturnSwapAdditionalPayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments == null)  {
				this.additionalPayment = new ArrayList<>();
			}
			else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("mutualOrOptionalEarlyTerminationModel")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setMutualOrOptionalEarlyTerminationModel(MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel) {
			this.mutualOrOptionalEarlyTerminationModel = mutualOrOptionalEarlyTerminationModel==null?null:mutualOrOptionalEarlyTerminationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel) {
			this.equityUnderlyerProvisionsModel = equityUnderlyerProvisionsModel==null?null:equityUnderlyerProvisionsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public EquitySwapTransactionSupplement build() {
			return new EquitySwapTransactionSupplement.EquitySwapTransactionSupplementImpl(this);
		}
		
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder prune() {
			super.prune();
			if (mutualOrOptionalEarlyTerminationModel!=null && !mutualOrOptionalEarlyTerminationModel.prune().hasData()) mutualOrOptionalEarlyTerminationModel = null;
			if (equityUnderlyerProvisionsModel!=null && !equityUnderlyerProvisionsModel.prune().hasData()) equityUnderlyerProvisionsModel = null;
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMutualOrOptionalEarlyTerminationModel()!=null && getMutualOrOptionalEarlyTerminationModel().hasData()) return true;
			if (getEquityUnderlyerProvisionsModel()!=null && getEquityUnderlyerProvisionsModel().hasData()) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder o = (EquitySwapTransactionSupplement.EquitySwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getMutualOrOptionalEarlyTerminationModel(), o.getMutualOrOptionalEarlyTerminationModel(), this::setMutualOrOptionalEarlyTerminationModel);
			merger.mergeRosetta(getEquityUnderlyerProvisionsModel(), o.getEquityUnderlyerProvisionsModel(), this::setEquityUnderlyerProvisionsModel);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EquitySwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(mutualOrOptionalEarlyTerminationModel, _that.getMutualOrOptionalEarlyTerminationModel())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (mutualOrOptionalEarlyTerminationModel != null ? mutualOrOptionalEarlyTerminationModel.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquitySwapTransactionSupplementBuilder {" +
				"mutualOrOptionalEarlyTerminationModel=" + this.mutualOrOptionalEarlyTerminationModel + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
