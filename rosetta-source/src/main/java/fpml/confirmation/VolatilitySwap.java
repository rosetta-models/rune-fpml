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
import fpml.confirmation.ClassifiablePayment;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilder;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseBuilderImpl;
import fpml.confirmation.NettedSwapBase.NettedSwapBaseImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilitySwap;
import fpml.confirmation.VolatilitySwap.VolatilitySwapBuilder;
import fpml.confirmation.VolatilitySwap.VolatilitySwapBuilderImpl;
import fpml.confirmation.VolatilitySwap.VolatilitySwapImpl;
import fpml.confirmation.meta.VolatilitySwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a volatility swap. A Volatility Swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="VolatilitySwap", builder=VolatilitySwap.VolatilitySwapBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface VolatilitySwap extends NettedSwapBase {

	VolatilitySwapMeta metaData = new VolatilitySwapMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends VolatilityLeg> getVolatilityLeg();

	/*********************** Build Methods  ***********************/
	VolatilitySwap build();
	
	VolatilitySwap.VolatilitySwapBuilder toBuilder();
	
	static VolatilitySwap.VolatilitySwapBuilder builder() {
		return new VolatilitySwap.VolatilitySwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilitySwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilitySwap> getType() {
		return VolatilitySwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.class, getExtraordinaryEvents());
		processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.class, getVolatilityLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilitySwapBuilder extends VolatilitySwap, NettedSwapBase.NettedSwapBaseBuilder {
		VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int _index);
		List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg();
		VolatilitySwap.VolatilitySwapBuilder setProductModel(ProductModel productModel);
		VolatilitySwap.VolatilitySwapBuilder setId(String id);
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment0);
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment1, int _idx);
		VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment2);
		VolatilitySwap.VolatilitySwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayment3);
		VolatilitySwap.VolatilitySwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg0);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg1, int _idx);
		VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg2);
		VolatilitySwap.VolatilitySwapBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLeg3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("additionalPayment"), processor, ClassifiablePayment.ClassifiablePaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("extraordinaryEvents"), processor, ExtraordinaryEvents.ExtraordinaryEventsBuilder.class, getExtraordinaryEvents());
			processRosetta(path.newSubPath("volatilityLeg"), processor, VolatilityLeg.VolatilityLegBuilder.class, getVolatilityLeg());
		}
		

		VolatilitySwap.VolatilitySwapBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilitySwap  ***********************/
	class VolatilitySwapImpl extends NettedSwapBase.NettedSwapBaseImpl implements VolatilitySwap {
		private final List<? extends VolatilityLeg> volatilityLeg;
		
		protected VolatilitySwapImpl(VolatilitySwap.VolatilitySwapBuilder builder) {
			super(builder);
			this.volatilityLeg = ofNullable(builder.getVolatilityLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("volatilityLeg")
		public List<? extends VolatilityLeg> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		@Override
		public VolatilitySwap build() {
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder toBuilder() {
			VolatilitySwap.VolatilitySwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilitySwap.VolatilitySwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVolatilityLeg()).ifPresent(builder::setVolatilityLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwap {" +
				"volatilityLeg=" + this.volatilityLeg +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilitySwap  ***********************/
	class VolatilitySwapBuilderImpl extends NettedSwapBase.NettedSwapBaseBuilderImpl  implements VolatilitySwap.VolatilitySwapBuilder {
	
		protected List<VolatilityLeg.VolatilityLegBuilder> volatilityLeg = new ArrayList<>();
	
		public VolatilitySwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("volatilityLeg")
		public List<? extends VolatilityLeg.VolatilityLegBuilder> getVolatilityLeg() {
			return volatilityLeg;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder getOrCreateVolatilityLeg(int _index) {
		
			if (volatilityLeg==null) {
				this.volatilityLeg = new ArrayList<>();
			}
			VolatilityLeg.VolatilityLegBuilder result;
			return getIndex(volatilityLeg, _index, () -> {
						VolatilityLeg.VolatilityLegBuilder newVolatilityLeg = VolatilityLeg.builder();
						return newVolatilityLeg;
					});
		}
		
		@Override
		@RosettaAttribute("productModel")
		public VolatilitySwap.VolatilitySwapBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VolatilitySwap.VolatilitySwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("additionalPayment")
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment) {
			if (additionalPayment!=null) this.additionalPayment.add(additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(ClassifiablePayment additionalPayment, int _idx) {
			getIndex(this.additionalPayment, _idx, () -> additionalPayment.toBuilder());
			return this;
		}
		@Override 
		public VolatilitySwap.VolatilitySwapBuilder addAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
			if (additionalPayments != null) {
				for (ClassifiablePayment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public VolatilitySwap.VolatilitySwapBuilder setAdditionalPayment(List<? extends ClassifiablePayment> additionalPayments) {
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
		@RosettaAttribute("extraordinaryEvents")
		public VolatilitySwap.VolatilitySwapBuilder setExtraordinaryEvents(ExtraordinaryEvents extraordinaryEvents) {
			this.extraordinaryEvents = extraordinaryEvents==null?null:extraordinaryEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("volatilityLeg")
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg) {
			if (volatilityLeg!=null) this.volatilityLeg.add(volatilityLeg.toBuilder());
			return this;
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(VolatilityLeg volatilityLeg, int _idx) {
			getIndex(this.volatilityLeg, _idx, () -> volatilityLeg.toBuilder());
			return this;
		}
		@Override 
		public VolatilitySwap.VolatilitySwapBuilder addVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs != null) {
				for (VolatilityLeg toAdd : volatilityLegs) {
					this.volatilityLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public VolatilitySwap.VolatilitySwapBuilder setVolatilityLeg(List<? extends VolatilityLeg> volatilityLegs) {
			if (volatilityLegs == null)  {
				this.volatilityLeg = new ArrayList<>();
			}
			else {
				this.volatilityLeg = volatilityLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public VolatilitySwap build() {
			return new VolatilitySwap.VolatilitySwapImpl(this);
		}
		
		@Override
		public VolatilitySwap.VolatilitySwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder prune() {
			super.prune();
			volatilityLeg = volatilityLeg.stream().filter(b->b!=null).<VolatilityLeg.VolatilityLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVolatilityLeg()!=null && getVolatilityLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilitySwap.VolatilitySwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilitySwap.VolatilitySwapBuilder o = (VolatilitySwap.VolatilitySwapBuilder) other;
			
			merger.mergeRosetta(getVolatilityLeg(), o.getVolatilityLeg(), this::getOrCreateVolatilityLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilitySwap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(volatilityLeg, _that.getVolatilityLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (volatilityLeg != null ? volatilityLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilitySwapBuilder {" +
				"volatilityLeg=" + this.volatilityLeg +
			'}' + " " + super.toString();
		}
	}
}
