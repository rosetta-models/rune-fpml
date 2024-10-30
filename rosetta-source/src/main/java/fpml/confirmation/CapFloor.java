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
import fpml.confirmation.CapFloor;
import fpml.confirmation.CapFloor.CapFloorBuilder;
import fpml.confirmation.CapFloor.CapFloorBuilderImpl;
import fpml.confirmation.CapFloor.CapFloorImpl;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.CapFloorMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A cap, floor or cap floor structures product definition. A type defining an interest rate cap, floor, or cap/floor strategy (e.g. collar) product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CapFloor", builder=CapFloor.CapFloorBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CapFloor extends Product {

	CapFloorMeta metaData = new CapFloorMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the leg, where date adjustments may apply.
	 */
	InterestRateStream getCapFloorStream();
	/**
	 * The option premium amount payable by buyer to seller on the specified payment date.
	 */
	List<? extends Payment> getPremium();
	/**
	 * Additional payments between the principal parties.
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 * Parameters specifying provisions relating to the optional and mandatory early terminarion of a CapFloor transaction.
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();

	/*********************** Build Methods  ***********************/
	CapFloor build();
	
	CapFloor.CapFloorBuilder toBuilder();
	
	static CapFloor.CapFloorBuilder builder() {
		return new CapFloor.CapFloorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CapFloor> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CapFloor> getType() {
		return CapFloor.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("capFloorStream"), processor, InterestRateStream.class, getCapFloorStream());
		processRosetta(path.newSubPath("premium"), processor, Payment.class, getPremium());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CapFloorBuilder extends CapFloor, Product.ProductBuilder {
		InterestRateStream.InterestRateStreamBuilder getOrCreateCapFloorStream();
		InterestRateStream.InterestRateStreamBuilder getCapFloorStream();
		Payment.PaymentBuilder getOrCreatePremium(int _index);
		List<? extends Payment.PaymentBuilder> getPremium();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		CapFloor.CapFloorBuilder setProductModel(ProductModel productModel);
		CapFloor.CapFloorBuilder setId(String id);
		CapFloor.CapFloorBuilder setCapFloorStream(InterestRateStream capFloorStream);
		CapFloor.CapFloorBuilder addPremium(Payment premium0);
		CapFloor.CapFloorBuilder addPremium(Payment premium1, int _idx);
		CapFloor.CapFloorBuilder addPremium(List<? extends Payment> premium2);
		CapFloor.CapFloorBuilder setPremium(List<? extends Payment> premium3);
		CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment0);
		CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		CapFloor.CapFloorBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		CapFloor.CapFloorBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);
		CapFloor.CapFloorBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("capFloorStream"), processor, InterestRateStream.InterestRateStreamBuilder.class, getCapFloorStream());
			processRosetta(path.newSubPath("premium"), processor, Payment.PaymentBuilder.class, getPremium());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
		}
		

		CapFloor.CapFloorBuilder prune();
	}

	/*********************** Immutable Implementation of CapFloor  ***********************/
	class CapFloorImpl extends Product.ProductImpl implements CapFloor {
		private final InterestRateStream capFloorStream;
		private final List<? extends Payment> premium;
		private final List<? extends Payment> additionalPayment;
		private final EarlyTerminationProvision earlyTerminationProvision;
		
		protected CapFloorImpl(CapFloor.CapFloorBuilder builder) {
			super(builder);
			this.capFloorStream = ofNullable(builder.getCapFloorStream()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("capFloorStream")
		public InterestRateStream getCapFloorStream() {
			return capFloorStream;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends Payment> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public CapFloor build() {
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder toBuilder() {
			CapFloor.CapFloorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CapFloor.CapFloorBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCapFloorStream()).ifPresent(builder::setCapFloorStream);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CapFloor _that = getType().cast(o);
		
			if (!Objects.equals(capFloorStream, _that.getCapFloorStream())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (capFloorStream != null ? capFloorStream.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CapFloor {" +
				"capFloorStream=" + this.capFloorStream + ", " +
				"premium=" + this.premium + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CapFloor  ***********************/
	class CapFloorBuilderImpl extends Product.ProductBuilderImpl  implements CapFloor.CapFloorBuilder {
	
		protected InterestRateStream.InterestRateStreamBuilder capFloorStream;
		protected List<Payment.PaymentBuilder> premium = new ArrayList<>();
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
	
		public CapFloorBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("capFloorStream")
		public InterestRateStream.InterestRateStreamBuilder getCapFloorStream() {
			return capFloorStream;
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder getOrCreateCapFloorStream() {
			InterestRateStream.InterestRateStreamBuilder result;
			if (capFloorStream!=null) {
				result = capFloorStream;
			}
			else {
				result = capFloorStream = InterestRateStream.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		public List<? extends Payment.PaymentBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreatePremium(int _index) {
		
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(premium, _index, () -> {
						Payment.PaymentBuilder newPremium = Payment.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index) {
		
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			Payment.PaymentBuilder result;
			return getIndex(additionalPayment, _index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder result;
			if (earlyTerminationProvision!=null) {
				result = earlyTerminationProvision;
			}
			else {
				result = earlyTerminationProvision = EarlyTerminationProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public CapFloor.CapFloorBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CapFloor.CapFloorBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("capFloorStream")
		public CapFloor.CapFloorBuilder setCapFloorStream(InterestRateStream capFloorStream) {
			this.capFloorStream = capFloorStream==null?null:capFloorStream.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("premium")
		public CapFloor.CapFloorBuilder addPremium(Payment premium) {
			if (premium!=null) this.premium.add(premium.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addPremium(Payment premium, int _idx) {
			getIndex(this.premium, _idx, () -> premium.toBuilder());
			return this;
		}
		@Override 
		public CapFloor.CapFloorBuilder addPremium(List<? extends Payment> premiums) {
			if (premiums != null) {
				for (Payment toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CapFloor.CapFloorBuilder setPremium(List<? extends Payment> premiums) {
			if (premiums == null)  {
				this.premium = new ArrayList<>();
			}
			else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public CapFloor.CapFloorBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public CapFloor.CapFloorBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CapFloor.CapFloorBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		@RosettaAttribute("earlyTerminationProvision")
		public CapFloor.CapFloorBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision) {
			this.earlyTerminationProvision = earlyTerminationProvision==null?null:earlyTerminationProvision.toBuilder();
			return this;
		}
		
		@Override
		public CapFloor build() {
			return new CapFloor.CapFloorImpl(this);
		}
		
		@Override
		public CapFloor.CapFloorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CapFloor.CapFloorBuilder prune() {
			super.prune();
			if (capFloorStream!=null && !capFloorStream.prune().hasData()) capFloorStream = null;
			premium = premium.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCapFloorStream()!=null && getCapFloorStream().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CapFloor.CapFloorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CapFloor.CapFloorBuilder o = (CapFloor.CapFloorBuilder) other;
			
			merger.mergeRosetta(getCapFloorStream(), o.getCapFloorStream(), this::setCapFloorStream);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CapFloor _that = getType().cast(o);
		
			if (!Objects.equals(capFloorStream, _that.getCapFloorStream())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (capFloorStream != null ? capFloorStream.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CapFloorBuilder {" +
				"capFloorStream=" + this.capFloorStream + ", " +
				"premium=" + this.premium + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision +
			'}' + " " + super.toString();
		}
	}
}
