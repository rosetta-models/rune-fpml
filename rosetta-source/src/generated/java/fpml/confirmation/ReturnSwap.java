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
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.PrincipalExchangeFeatures;
import fpml.confirmation.ProductModel;
import fpml.confirmation.ReturnSwap;
import fpml.confirmation.ReturnSwap.ReturnSwapBuilder;
import fpml.confirmation.ReturnSwap.ReturnSwapBuilderImpl;
import fpml.confirmation.ReturnSwap.ReturnSwapImpl;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.ReturnSwapBase;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilder;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseBuilderImpl;
import fpml.confirmation.ReturnSwapBase.ReturnSwapBaseImpl;
import fpml.confirmation.ReturnSwapEarlyTermination;
import fpml.confirmation.meta.ReturnSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a return type swap. It can represent return swaps, total return swaps, variance swaps. A type describing return swaps including return swaps (long form), total return swaps, and variance swaps.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwap", builder=ReturnSwap.ReturnSwapBuilderImpl.class, version="${project.version}")
public interface ReturnSwap extends ReturnSwapBase {

	ReturnSwapMeta metaData = new ReturnSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies, for one or for both the parties to the trade, the date from which it can early terminate it.
	 */
	List<? extends ReturnSwapEarlyTermination> getEarlyTermination();
	/**
	 * Where the underlying is shares, specifies events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
	 */
	ExtraordinaryEvents getExtraordinaryEvents();

	/*********************** Build Methods  ***********************/
	ReturnSwap build();
	
	ReturnSwap.ReturnSwapBuilder toBuilder();
	
	static ReturnSwap.ReturnSwapBuilder builder() {
		return new ReturnSwap.ReturnSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwap> getType() {
		return ReturnSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.class, getBuyerSellerModel());
		processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.class, getReturnSwapLeg());
		processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.class, getPrincipalExchangeFeatures());
		processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("earlyTermination"), processor, ReturnSwapEarlyTermination.class, getEarlyTermination());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapBuilder extends ReturnSwap, ReturnSwapBase.ReturnSwapBaseBuilder {
		ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int _index);
		List<? extends ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> getEarlyTermination();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getOrCreateExtraordinaryEvents();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder getExtraordinaryEvents();
		ReturnSwap.ReturnSwapBuilder setProductModel(ProductModel productModel);
		ReturnSwap.ReturnSwapBuilder setId(String id);
		ReturnSwap.ReturnSwapBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel);
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg0);
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg1, int _idx);
		ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg2);
		ReturnSwap.ReturnSwapBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLeg3);
		ReturnSwap.ReturnSwapBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures);
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment0);
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment1, int _idx);
		ReturnSwap.ReturnSwapBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment2);
		ReturnSwap.ReturnSwapBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayment3);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination0);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination1, int _idx);
		ReturnSwap.ReturnSwapBuilder addEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTermination2);
		ReturnSwap.ReturnSwapBuilder setEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTermination3);
		ReturnSwap.ReturnSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("buyerSellerModel"), processor, BuyerSellerModel.BuyerSellerModelBuilder.class, getBuyerSellerModel());
			processRosetta(path.newSubPath("returnSwapLeg"), processor, DirectionalLeg.DirectionalLegBuilder.class, getReturnSwapLeg());
			processRosetta(path.newSubPath("principalExchangeFeatures"), processor, PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder.class, getPrincipalExchangeFeatures());
			processRosetta(path.newSubPath("additionalPayment"), processor, ReturnSwapAdditionalPayment.ReturnSwapAdditionalPaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("earlyTermination"), processor, ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder.class, getEarlyTermination());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
		}
		

		ReturnSwap.ReturnSwapBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwap  ***********************/
	class ReturnSwapImpl extends ReturnSwapBase.ReturnSwapBaseImpl implements ReturnSwap {
		private final List<? extends ReturnSwapEarlyTermination> earlyTermination;
		private final ExtraordinaryEvents extraordinaryEvents;
		
		protected ReturnSwapImpl(ReturnSwap.ReturnSwapBuilder builder) {
			super(builder);
			this.earlyTermination = ofNullable(builder.getEarlyTermination()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.extraordinaryEvents = ofNullable(builder.getExtraordinaryEvents()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("earlyTermination")
		public List<? extends ReturnSwapEarlyTermination> getEarlyTermination() {
			return earlyTermination;
		}
		
		@Override
		@RosettaAttribute("extraordinaryEvents")
		public ExtraordinaryEvents getExtraordinaryEvents() {
			return extraordinaryEvents;
		}
		
		@Override
		public ReturnSwap build() {
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder toBuilder() {
			ReturnSwap.ReturnSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwap.ReturnSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getEarlyTermination()).ifPresent(builder::setEarlyTermination);
			ofNullable(getExtraordinaryEvents()).ifPresent(builder::setExtraordinaryEvents);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwap {" +
				"earlyTermination=" + this.earlyTermination + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ReturnSwap  ***********************/
	class ReturnSwapBuilderImpl extends ReturnSwapBase.ReturnSwapBaseBuilderImpl  implements ReturnSwap.ReturnSwapBuilder {
	
		protected List<ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> earlyTermination = new ArrayList<>();
		protected ExtraordinaryEvents.ExtraordinaryEventsBuilder extraordinaryEvents;
	
		public ReturnSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("earlyTermination")
		public List<? extends ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder> getEarlyTermination() {
			return earlyTermination;
		}
		
		public ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder getOrCreateEarlyTermination(int _index) {
		
			if (earlyTermination==null) {
				this.earlyTermination = new ArrayList<>();
			}
			ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder result;
			return getIndex(earlyTermination, _index, () -> {
						ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder newEarlyTermination = ReturnSwapEarlyTermination.builder();
						return newEarlyTermination;
					});
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
		public ReturnSwap.ReturnSwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReturnSwap.ReturnSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("buyerSellerModel")
		public ReturnSwap.ReturnSwapBuilder setBuyerSellerModel(BuyerSellerModel buyerSellerModel) {
			this.buyerSellerModel = buyerSellerModel==null?null:buyerSellerModel.toBuilder();
			return this;
		}
		@Override
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg) {
			if (returnSwapLeg!=null) this.returnSwapLeg.add(returnSwapLeg.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(DirectionalLeg returnSwapLeg, int _idx) {
			getIndex(this.returnSwapLeg, _idx, () -> returnSwapLeg.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwap.ReturnSwapBuilder addReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
			if (returnSwapLegs != null) {
				for (DirectionalLeg toAdd : returnSwapLegs) {
					this.returnSwapLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("returnSwapLeg")
		public ReturnSwap.ReturnSwapBuilder setReturnSwapLeg(List<? extends DirectionalLeg> returnSwapLegs) {
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
		public ReturnSwap.ReturnSwapBuilder setPrincipalExchangeFeatures(PrincipalExchangeFeatures principalExchangeFeatures) {
			this.principalExchangeFeatures = principalExchangeFeatures==null?null:principalExchangeFeatures.toBuilder();
			return this;
		}
		@Override
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(ReturnSwapAdditionalPayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwap.ReturnSwapBuilder addAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ReturnSwapAdditionalPayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public ReturnSwap.ReturnSwapBuilder setAdditionalPayment(List<? extends ReturnSwapAdditionalPayment> additionalPayments) {
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
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination) {
			if (earlyTermination!=null) this.earlyTermination.add(earlyTermination.toBuilder());
			return this;
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(ReturnSwapEarlyTermination earlyTermination, int _idx) {
			getIndex(this.earlyTermination, _idx, () -> earlyTermination.toBuilder());
			return this;
		}
		@Override 
		public ReturnSwap.ReturnSwapBuilder addEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTerminations) {
			if (earlyTerminations != null) {
				for (ReturnSwapEarlyTermination toAdd : earlyTerminations) {
					this.earlyTermination.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("earlyTermination")
		public ReturnSwap.ReturnSwapBuilder setEarlyTermination(List<? extends ReturnSwapEarlyTermination> earlyTerminations) {
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
		@RosettaAttribute("extraordinaryEvents")
		public ReturnSwap.ReturnSwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		
		@Override
		public ReturnSwap build() {
			return new ReturnSwap.ReturnSwapImpl(this);
		}
		
		@Override
		public ReturnSwap.ReturnSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwap.ReturnSwapBuilder prune() {
			super.prune();
			earlyTermination = earlyTermination.stream().filter(b->b!=null).<ReturnSwapEarlyTermination.ReturnSwapEarlyTerminationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (extraordinaryEvents!=null && !extraordinaryEvents.prune().hasData()) extraordinaryEvents = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getEarlyTermination()!=null && getEarlyTermination().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExtraordinaryEvents()!=null && getExtraordinaryEvents().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwap.ReturnSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ReturnSwap.ReturnSwapBuilder o = (ReturnSwap.ReturnSwapBuilder) other;
			
			merger.mergeRosetta(getEarlyTermination(), o.getEarlyTermination(), this::getOrCreateEarlyTermination);
			merger.mergeRosetta(getExtraordinaryEvents(), o.getExtraordinaryEvents(), this::setExtraordinaryEvents);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ReturnSwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(earlyTermination, _that.getEarlyTermination())) return false;
			if (!Objects.equals(extraordinaryEvents, _that.getExtraordinaryEvents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (earlyTermination != null ? earlyTermination.hashCode() : 0);
			_result = 31 * _result + (extraordinaryEvents != null ? extraordinaryEvents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapBuilder {" +
				"earlyTermination=" + this.earlyTermination + ", " +
				"extraordinaryEvents=" + this.extraordinaryEvents +
			'}' + " " + super.toString();
		}
	}
}
