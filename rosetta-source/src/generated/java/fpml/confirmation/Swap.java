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
import fpml.confirmation.CancelableProvision;
import fpml.confirmation.EarlyTerminationProvision;
import fpml.confirmation.ExtendibleProvision;
import fpml.confirmation.InterestRateStream;
import fpml.confirmation.Payment;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.Swap;
import fpml.confirmation.Swap.SwapBuilder;
import fpml.confirmation.Swap.SwapBuilderImpl;
import fpml.confirmation.Swap.SwapImpl;
import fpml.confirmation.SwapAdditionalTerms;
import fpml.confirmation.meta.SwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A swap product definition. A type defining swap streams and additional payments between the principal parties involved in the swap.
 * @version ${project.version}
 */
@RosettaDataType(value="Swap", builder=Swap.SwapBuilderImpl.class, version="${project.version}")
public interface Swap extends Product {

	SwapMeta metaData = new SwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The swap streams.
	 */
	List<? extends InterestRateStream> getSwapStream();
	/**
	 * Parameters specifying provisions relating to the optional and mandatory early terminarion of a swap transaction.
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();
	/**
	 * A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
	 */
	CancelableProvision getCancelableProvision();
	/**
	 * A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
	 */
	ExtendibleProvision getExtendibleProvision();
	/**
	 * Additional payments between the principal parties.
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 * Contains any additional terms to the swap contract.
	 */
	SwapAdditionalTerms getAdditionalTerms();

	/*********************** Build Methods  ***********************/
	Swap build();
	
	Swap.SwapBuilder toBuilder();
	
	static Swap.SwapBuilder builder() {
		return new Swap.SwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Swap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Swap> getType() {
		return Swap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("swapStream"), processor, InterestRateStream.class, getSwapStream());
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
		processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.class, getCancelableProvision());
		processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.class, getExtendibleProvision());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("additionalTerms"), processor, SwapAdditionalTerms.class, getAdditionalTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwapBuilder extends Swap, Product.ProductBuilder {
		InterestRateStream.InterestRateStreamBuilder getOrCreateSwapStream(int _index);
		List<? extends InterestRateStream.InterestRateStreamBuilder> getSwapStream();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision();
		CancelableProvision.CancelableProvisionBuilder getCancelableProvision();
		ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision();
		ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int _index);
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		SwapAdditionalTerms.SwapAdditionalTermsBuilder getOrCreateAdditionalTerms();
		SwapAdditionalTerms.SwapAdditionalTermsBuilder getAdditionalTerms();
		Swap.SwapBuilder setProductModel(ProductModel productModel);
		Swap.SwapBuilder setId(String id);
		Swap.SwapBuilder addSwapStream(InterestRateStream swapStream0);
		Swap.SwapBuilder addSwapStream(InterestRateStream swapStream1, int _idx);
		Swap.SwapBuilder addSwapStream(List<? extends InterestRateStream> swapStream2);
		Swap.SwapBuilder setSwapStream(List<? extends InterestRateStream> swapStream3);
		Swap.SwapBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);
		Swap.SwapBuilder setCancelableProvision(CancelableProvision cancelableProvision);
		Swap.SwapBuilder setExtendibleProvision(ExtendibleProvision extendibleProvision);
		Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment0);
		Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment1, int _idx);
		Swap.SwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment2);
		Swap.SwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment3);
		Swap.SwapBuilder setAdditionalTerms(SwapAdditionalTerms additionalTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("swapStream"), processor, InterestRateStream.InterestRateStreamBuilder.class, getSwapStream());
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
			processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.CancelableProvisionBuilder.class, getCancelableProvision());
			processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.ExtendibleProvisionBuilder.class, getExtendibleProvision());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("additionalTerms"), processor, SwapAdditionalTerms.SwapAdditionalTermsBuilder.class, getAdditionalTerms());
		}
		

		Swap.SwapBuilder prune();
	}

	/*********************** Immutable Implementation of Swap  ***********************/
	class SwapImpl extends Product.ProductImpl implements Swap {
		private final List<? extends InterestRateStream> swapStream;
		private final EarlyTerminationProvision earlyTerminationProvision;
		private final CancelableProvision cancelableProvision;
		private final ExtendibleProvision extendibleProvision;
		private final List<? extends Payment> additionalPayment;
		private final SwapAdditionalTerms additionalTerms;
		
		protected SwapImpl(Swap.SwapBuilder builder) {
			super(builder);
			this.swapStream = ofNullable(builder.getSwapStream()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
			this.cancelableProvision = ofNullable(builder.getCancelableProvision()).map(f->f.build()).orElse(null);
			this.extendibleProvision = ofNullable(builder.getExtendibleProvision()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalTerms = ofNullable(builder.getAdditionalTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("swapStream")
		public List<? extends InterestRateStream> getSwapStream() {
			return swapStream;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		@RosettaAttribute("cancelableProvision")
		public CancelableProvision getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		@RosettaAttribute("extendibleProvision")
		public ExtendibleProvision getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("additionalTerms")
		public SwapAdditionalTerms getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public Swap build() {
			return this;
		}
		
		@Override
		public Swap.SwapBuilder toBuilder() {
			Swap.SwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Swap.SwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSwapStream()).ifPresent(builder::setSwapStream);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
			ofNullable(getCancelableProvision()).ifPresent(builder::setCancelableProvision);
			ofNullable(getExtendibleProvision()).ifPresent(builder::setExtendibleProvision);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getAdditionalTerms()).ifPresent(builder::setAdditionalTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(swapStream, _that.getSwapStream())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (swapStream != null ? swapStream.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Swap {" +
				"swapStream=" + this.swapStream + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Swap  ***********************/
	class SwapBuilderImpl extends Product.ProductBuilderImpl  implements Swap.SwapBuilder {
	
		protected List<InterestRateStream.InterestRateStreamBuilder> swapStream = new ArrayList<>();
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
		protected CancelableProvision.CancelableProvisionBuilder cancelableProvision;
		protected ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvision;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected SwapAdditionalTerms.SwapAdditionalTermsBuilder additionalTerms;
	
		public SwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("swapStream")
		public List<? extends InterestRateStream.InterestRateStreamBuilder> getSwapStream() {
			return swapStream;
		}
		
		public InterestRateStream.InterestRateStreamBuilder getOrCreateSwapStream(int _index) {
		
			if (swapStream==null) {
				this.swapStream = new ArrayList<>();
			}
			InterestRateStream.InterestRateStreamBuilder result;
			return getIndex(swapStream, _index, () -> {
						InterestRateStream.InterestRateStreamBuilder newSwapStream = InterestRateStream.builder();
						return newSwapStream;
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
		@RosettaAttribute("cancelableProvision")
		public CancelableProvision.CancelableProvisionBuilder getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision() {
			CancelableProvision.CancelableProvisionBuilder result;
			if (cancelableProvision!=null) {
				result = cancelableProvision;
			}
			else {
				result = cancelableProvision = CancelableProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extendibleProvision")
		public ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision() {
			ExtendibleProvision.ExtendibleProvisionBuilder result;
			if (extendibleProvision!=null) {
				result = extendibleProvision;
			}
			else {
				result = extendibleProvision = ExtendibleProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
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
		@RosettaAttribute("additionalTerms")
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder getOrCreateAdditionalTerms() {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder result;
			if (additionalTerms!=null) {
				result = additionalTerms;
			}
			else {
				result = additionalTerms = SwapAdditionalTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public Swap.SwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Swap.SwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Swap.SwapBuilder addSwapStream(InterestRateStream swapStream) {
			if (swapStream!=null) this.swapStream.add(swapStream.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addSwapStream(InterestRateStream swapStream, int _idx) {
			getIndex(this.swapStream, _idx, () -> swapStream.toBuilder());
			return this;
		}
		@Override 
		public Swap.SwapBuilder addSwapStream(List<? extends InterestRateStream> swapStreams) {
			if (swapStreams != null) {
				for (InterestRateStream toAdd : swapStreams) {
					this.swapStream.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("swapStream")
		public Swap.SwapBuilder setSwapStream(List<? extends InterestRateStream> swapStreams) {
			if (swapStreams == null)  {
				this.swapStream = new ArrayList<>();
			}
			else {
				this.swapStream = swapStreams.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		public Swap.SwapBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision) {
			this.earlyTerminationProvision = earlyTerminationProvision==null?null:earlyTerminationProvision.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cancelableProvision")
		public Swap.SwapBuilder setCancelableProvision(CancelableProvision cancelableProvision) {
			this.cancelableProvision = cancelableProvision==null?null:cancelableProvision.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("extendibleProvision")
		public Swap.SwapBuilder setExtendibleProvision(ExtendibleProvision extendibleProvision) {
			this.extendibleProvision = extendibleProvision==null?null:extendibleProvision.toBuilder();
			return this;
		}
		@Override
		public Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public Swap.SwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("additionalPayment")
		public Swap.SwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
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
		@RosettaAttribute("additionalTerms")
		public Swap.SwapBuilder setAdditionalTerms(SwapAdditionalTerms additionalTerms) {
			this.additionalTerms = additionalTerms==null?null:additionalTerms.toBuilder();
			return this;
		}
		
		@Override
		public Swap build() {
			return new Swap.SwapImpl(this);
		}
		
		@Override
		public Swap.SwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swap.SwapBuilder prune() {
			super.prune();
			swapStream = swapStream.stream().filter(b->b!=null).<InterestRateStream.InterestRateStreamBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			if (cancelableProvision!=null && !cancelableProvision.prune().hasData()) cancelableProvision = null;
			if (extendibleProvision!=null && !extendibleProvision.prune().hasData()) extendibleProvision = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalTerms!=null && !additionalTerms.prune().hasData()) additionalTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSwapStream()!=null && getSwapStream().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			if (getCancelableProvision()!=null && getCancelableProvision().hasData()) return true;
			if (getExtendibleProvision()!=null && getExtendibleProvision().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalTerms()!=null && getAdditionalTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swap.SwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Swap.SwapBuilder o = (Swap.SwapBuilder) other;
			
			merger.mergeRosetta(getSwapStream(), o.getSwapStream(), this::getOrCreateSwapStream);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			merger.mergeRosetta(getCancelableProvision(), o.getCancelableProvision(), this::setCancelableProvision);
			merger.mergeRosetta(getExtendibleProvision(), o.getExtendibleProvision(), this::setExtendibleProvision);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getAdditionalTerms(), o.getAdditionalTerms(), this::setAdditionalTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(swapStream, _that.getSwapStream())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (swapStream != null ? swapStream.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapBuilder {" +
				"swapStream=" + this.swapStream + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}' + " " + super.toString();
		}
	}
}
