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
import fpml.confirmation.FeeLegChoiceSequence1;
import fpml.confirmation.FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder;
import fpml.confirmation.FeeLegChoiceSequence1.FeeLegChoiceSequence1BuilderImpl;
import fpml.confirmation.FeeLegChoiceSequence1.FeeLegChoiceSequence1Impl;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.SinglePayment;
import fpml.confirmation.meta.FeeLegChoiceSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FeeLegChoiceSequence1", builder=FeeLegChoiceSequence1.FeeLegChoiceSequence1BuilderImpl.class, version="${project.version}")
public interface FeeLegChoiceSequence1 extends RosettaModelObject {

	FeeLegChoiceSequence1Meta metaData = new FeeLegChoiceSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies a single fixed amount that is payable by the buyer to the seller on the fixed rate payer payment date. The fixed amount to be paid is specified in terms of a known currency amount.
	 */
	List<? extends SinglePayment> getSinglePayment();
	/**
	 * Specifies a periodic schedule of fixed amounts that are payable by the buyer to the seller on the fixed rate payer payment dates. The fixed amount to be paid on each payment date can be specified in terms of a known currency amount or as an amount calculated on a formula basis by reference to a per annum fixed rate. The applicable business day convention and business day for adjusting any fixed rate payer payment date if it would otherwise fall on a day that is not a business day are those specified in the dateAdjustments element within the generalTerms component. ISDA 2003 Term:
	 */
	PeriodicPayment getPeriodicPayment();

	/*********************** Build Methods  ***********************/
	FeeLegChoiceSequence1 build();
	
	FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder toBuilder();
	
	static FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder builder() {
		return new FeeLegChoiceSequence1.FeeLegChoiceSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FeeLegChoiceSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FeeLegChoiceSequence1> getType() {
		return FeeLegChoiceSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("singlePayment"), processor, SinglePayment.class, getSinglePayment());
		processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.class, getPeriodicPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FeeLegChoiceSequence1Builder extends FeeLegChoiceSequence1, RosettaModelObjectBuilder {
		SinglePayment.SinglePaymentBuilder getOrCreateSinglePayment(int _index);
		List<? extends SinglePayment.SinglePaymentBuilder> getSinglePayment();
		PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment();
		PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment();
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(SinglePayment singlePayment0);
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(SinglePayment singlePayment1, int _idx);
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(List<? extends SinglePayment> singlePayment2);
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder setSinglePayment(List<? extends SinglePayment> singlePayment3);
		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder setPeriodicPayment(PeriodicPayment periodicPayment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("singlePayment"), processor, SinglePayment.SinglePaymentBuilder.class, getSinglePayment());
			processRosetta(path.newSubPath("periodicPayment"), processor, PeriodicPayment.PeriodicPaymentBuilder.class, getPeriodicPayment());
		}
		

		FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FeeLegChoiceSequence1  ***********************/
	class FeeLegChoiceSequence1Impl implements FeeLegChoiceSequence1 {
		private final List<? extends SinglePayment> singlePayment;
		private final PeriodicPayment periodicPayment;
		
		protected FeeLegChoiceSequence1Impl(FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder builder) {
			this.singlePayment = ofNullable(builder.getSinglePayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.periodicPayment = ofNullable(builder.getPeriodicPayment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("singlePayment")
		public List<? extends SinglePayment> getSinglePayment() {
			return singlePayment;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public FeeLegChoiceSequence1 build() {
			return this;
		}
		
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder toBuilder() {
			FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder builder) {
			ofNullable(getSinglePayment()).ifPresent(builder::setSinglePayment);
			ofNullable(getPeriodicPayment()).ifPresent(builder::setPeriodicPayment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoiceSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(singlePayment, _that.getSinglePayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePayment != null ? singlePayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoiceSequence1 {" +
				"singlePayment=" + this.singlePayment + ", " +
				"periodicPayment=" + this.periodicPayment +
			'}';
		}
	}

	/*********************** Builder Implementation of FeeLegChoiceSequence1  ***********************/
	class FeeLegChoiceSequence1BuilderImpl implements FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder {
	
		protected List<SinglePayment.SinglePaymentBuilder> singlePayment = new ArrayList<>();
		protected PeriodicPayment.PeriodicPaymentBuilder periodicPayment;
	
		public FeeLegChoiceSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("singlePayment")
		public List<? extends SinglePayment.SinglePaymentBuilder> getSinglePayment() {
			return singlePayment;
		}
		
		public SinglePayment.SinglePaymentBuilder getOrCreateSinglePayment(int _index) {
		
			if (singlePayment==null) {
				this.singlePayment = new ArrayList<>();
			}
			SinglePayment.SinglePaymentBuilder result;
			return getIndex(singlePayment, _index, () -> {
						SinglePayment.SinglePaymentBuilder newSinglePayment = SinglePayment.builder();
						return newSinglePayment;
					});
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public PeriodicPayment.PeriodicPaymentBuilder getPeriodicPayment() {
			return periodicPayment;
		}
		
		@Override
		public PeriodicPayment.PeriodicPaymentBuilder getOrCreatePeriodicPayment() {
			PeriodicPayment.PeriodicPaymentBuilder result;
			if (periodicPayment!=null) {
				result = periodicPayment;
			}
			else {
				result = periodicPayment = PeriodicPayment.builder();
			}
			
			return result;
		}
		
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(SinglePayment singlePayment) {
			if (singlePayment!=null) this.singlePayment.add(singlePayment.toBuilder());
			return this;
		}
		
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(SinglePayment singlePayment, int _idx) {
			getIndex(this.singlePayment, _idx, () -> singlePayment.toBuilder());
			return this;
		}
		@Override 
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder addSinglePayment(List<? extends SinglePayment> singlePayments) {
			if (singlePayments != null) {
				for (SinglePayment toAdd : singlePayments) {
					this.singlePayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("singlePayment")
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder setSinglePayment(List<? extends SinglePayment> singlePayments) {
			if (singlePayments == null)  {
				this.singlePayment = new ArrayList<>();
			}
			else {
				this.singlePayment = singlePayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("periodicPayment")
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder setPeriodicPayment(PeriodicPayment periodicPayment) {
			this.periodicPayment = periodicPayment==null?null:periodicPayment.toBuilder();
			return this;
		}
		
		@Override
		public FeeLegChoiceSequence1 build() {
			return new FeeLegChoiceSequence1.FeeLegChoiceSequence1Impl(this);
		}
		
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder prune() {
			singlePayment = singlePayment.stream().filter(b->b!=null).<SinglePayment.SinglePaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (periodicPayment!=null && !periodicPayment.prune().hasData()) periodicPayment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSinglePayment()!=null && getSinglePayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPeriodicPayment()!=null && getPeriodicPayment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder o = (FeeLegChoiceSequence1.FeeLegChoiceSequence1Builder) other;
			
			merger.mergeRosetta(getSinglePayment(), o.getSinglePayment(), this::getOrCreateSinglePayment);
			merger.mergeRosetta(getPeriodicPayment(), o.getPeriodicPayment(), this::setPeriodicPayment);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeeLegChoiceSequence1 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(singlePayment, _that.getSinglePayment())) return false;
			if (!Objects.equals(periodicPayment, _that.getPeriodicPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (singlePayment != null ? singlePayment.hashCode() : 0);
			_result = 31 * _result + (periodicPayment != null ? periodicPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeeLegChoiceSequence1Builder {" +
				"singlePayment=" + this.singlePayment + ", " +
				"periodicPayment=" + this.periodicPayment +
			'}';
		}
	}
}
