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
import fpml.confirmation.DividendPayout;
import fpml.confirmation.DividendPayout.DividendPayoutBuilder;
import fpml.confirmation.DividendPayout.DividendPayoutBuilderImpl;
import fpml.confirmation.DividendPayout.DividendPayoutImpl;
import fpml.confirmation.DividendPayoutSequence;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.meta.DividendPayoutMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing the dividend payout ratio associated with an equity underlyer. In certain cases the actual ratio is not known on trade inception, and only general conditions are then specified.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendPayout", builder=DividendPayout.DividendPayoutBuilderImpl.class, version="${project.version}")
public interface DividendPayout extends RosettaModelObject {

	DividendPayoutMeta metaData = new DividendPayoutMeta();

	/*********************** Getter Methods  ***********************/
	DividendPayoutSequence getDividendPayoutSequence();
	/**
	 * Specifies the dividend payout conditions that will be applied in the case where the actual ratio is not known, typically because of regulatory or legal uncertainties.
	 */
	String getDividendPayoutConditions();
	/**
	 * The next upcoming dividend payment or payments.
	 */
	List<? extends PendingPayment> getDividendPayment();

	/*********************** Build Methods  ***********************/
	DividendPayout build();
	
	DividendPayout.DividendPayoutBuilder toBuilder();
	
	static DividendPayout.DividendPayoutBuilder builder() {
		return new DividendPayout.DividendPayoutBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendPayout> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendPayout> getType() {
		return DividendPayout.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dividendPayoutSequence"), processor, DividendPayoutSequence.class, getDividendPayoutSequence());
		processor.processBasic(path.newSubPath("dividendPayoutConditions"), String.class, getDividendPayoutConditions(), this);
		processRosetta(path.newSubPath("dividendPayment"), processor, PendingPayment.class, getDividendPayment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendPayoutBuilder extends DividendPayout, RosettaModelObjectBuilder {
		DividendPayoutSequence.DividendPayoutSequenceBuilder getOrCreateDividendPayoutSequence();
		DividendPayoutSequence.DividendPayoutSequenceBuilder getDividendPayoutSequence();
		PendingPayment.PendingPaymentBuilder getOrCreateDividendPayment(int _index);
		List<? extends PendingPayment.PendingPaymentBuilder> getDividendPayment();
		DividendPayout.DividendPayoutBuilder setDividendPayoutSequence(DividendPayoutSequence dividendPayoutSequence);
		DividendPayout.DividendPayoutBuilder setDividendPayoutConditions(String dividendPayoutConditions);
		DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment0);
		DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment1, int _idx);
		DividendPayout.DividendPayoutBuilder addDividendPayment(List<? extends PendingPayment> dividendPayment2);
		DividendPayout.DividendPayoutBuilder setDividendPayment(List<? extends PendingPayment> dividendPayment3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dividendPayoutSequence"), processor, DividendPayoutSequence.DividendPayoutSequenceBuilder.class, getDividendPayoutSequence());
			processor.processBasic(path.newSubPath("dividendPayoutConditions"), String.class, getDividendPayoutConditions(), this);
			processRosetta(path.newSubPath("dividendPayment"), processor, PendingPayment.PendingPaymentBuilder.class, getDividendPayment());
		}
		

		DividendPayout.DividendPayoutBuilder prune();
	}

	/*********************** Immutable Implementation of DividendPayout  ***********************/
	class DividendPayoutImpl implements DividendPayout {
		private final DividendPayoutSequence dividendPayoutSequence;
		private final String dividendPayoutConditions;
		private final List<? extends PendingPayment> dividendPayment;
		
		protected DividendPayoutImpl(DividendPayout.DividendPayoutBuilder builder) {
			this.dividendPayoutSequence = ofNullable(builder.getDividendPayoutSequence()).map(f->f.build()).orElse(null);
			this.dividendPayoutConditions = builder.getDividendPayoutConditions();
			this.dividendPayment = ofNullable(builder.getDividendPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendPayoutSequence")
		public DividendPayoutSequence getDividendPayoutSequence() {
			return dividendPayoutSequence;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutConditions")
		public String getDividendPayoutConditions() {
			return dividendPayoutConditions;
		}
		
		@Override
		@RosettaAttribute("dividendPayment")
		public List<? extends PendingPayment> getDividendPayment() {
			return dividendPayment;
		}
		
		@Override
		public DividendPayout build() {
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			DividendPayout.DividendPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPayout.DividendPayoutBuilder builder) {
			ofNullable(getDividendPayoutSequence()).ifPresent(builder::setDividendPayoutSequence);
			ofNullable(getDividendPayoutConditions()).ifPresent(builder::setDividendPayoutConditions);
			ofNullable(getDividendPayment()).ifPresent(builder::setDividendPayment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutSequence, _that.getDividendPayoutSequence())) return false;
			if (!Objects.equals(dividendPayoutConditions, _that.getDividendPayoutConditions())) return false;
			if (!ListEquals.listEquals(dividendPayment, _that.getDividendPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutSequence != null ? dividendPayoutSequence.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutConditions != null ? dividendPayoutConditions.hashCode() : 0);
			_result = 31 * _result + (dividendPayment != null ? dividendPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayout {" +
				"dividendPayoutSequence=" + this.dividendPayoutSequence + ", " +
				"dividendPayoutConditions=" + this.dividendPayoutConditions + ", " +
				"dividendPayment=" + this.dividendPayment +
			'}';
		}
	}

	/*********************** Builder Implementation of DividendPayout  ***********************/
	class DividendPayoutBuilderImpl implements DividendPayout.DividendPayoutBuilder {
	
		protected DividendPayoutSequence.DividendPayoutSequenceBuilder dividendPayoutSequence;
		protected String dividendPayoutConditions;
		protected List<PendingPayment.PendingPaymentBuilder> dividendPayment = new ArrayList<>();
	
		public DividendPayoutBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendPayoutSequence")
		public DividendPayoutSequence.DividendPayoutSequenceBuilder getDividendPayoutSequence() {
			return dividendPayoutSequence;
		}
		
		@Override
		public DividendPayoutSequence.DividendPayoutSequenceBuilder getOrCreateDividendPayoutSequence() {
			DividendPayoutSequence.DividendPayoutSequenceBuilder result;
			if (dividendPayoutSequence!=null) {
				result = dividendPayoutSequence;
			}
			else {
				result = dividendPayoutSequence = DividendPayoutSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dividendPayoutConditions")
		public String getDividendPayoutConditions() {
			return dividendPayoutConditions;
		}
		
		@Override
		@RosettaAttribute("dividendPayment")
		public List<? extends PendingPayment.PendingPaymentBuilder> getDividendPayment() {
			return dividendPayment;
		}
		
		@Override
		public PendingPayment.PendingPaymentBuilder getOrCreateDividendPayment(int _index) {
		
			if (dividendPayment==null) {
				this.dividendPayment = new ArrayList<>();
			}
			PendingPayment.PendingPaymentBuilder result;
			return getIndex(dividendPayment, _index, () -> {
						PendingPayment.PendingPaymentBuilder newDividendPayment = PendingPayment.builder();
						return newDividendPayment;
					});
		}
		
		@Override
		@RosettaAttribute("dividendPayoutSequence")
		public DividendPayout.DividendPayoutBuilder setDividendPayoutSequence(DividendPayoutSequence dividendPayoutSequence) {
			this.dividendPayoutSequence = dividendPayoutSequence==null?null:dividendPayoutSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayoutConditions")
		public DividendPayout.DividendPayoutBuilder setDividendPayoutConditions(String dividendPayoutConditions) {
			this.dividendPayoutConditions = dividendPayoutConditions==null?null:dividendPayoutConditions;
			return this;
		}
		@Override
		@RosettaAttribute("dividendPayment")
		public DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment) {
			if (dividendPayment!=null) this.dividendPayment.add(dividendPayment.toBuilder());
			return this;
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder addDividendPayment(PendingPayment dividendPayment, int _idx) {
			getIndex(this.dividendPayment, _idx, () -> dividendPayment.toBuilder());
			return this;
		}
		@Override 
		public DividendPayout.DividendPayoutBuilder addDividendPayment(List<? extends PendingPayment> dividendPayments) {
			if (dividendPayments != null) {
				for (PendingPayment toAdd : dividendPayments) {
					this.dividendPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DividendPayout.DividendPayoutBuilder setDividendPayment(List<? extends PendingPayment> dividendPayments) {
			if (dividendPayments == null)  {
				this.dividendPayment = new ArrayList<>();
			}
			else {
				this.dividendPayment = dividendPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DividendPayout build() {
			return new DividendPayout.DividendPayoutImpl(this);
		}
		
		@Override
		public DividendPayout.DividendPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder prune() {
			if (dividendPayoutSequence!=null && !dividendPayoutSequence.prune().hasData()) dividendPayoutSequence = null;
			dividendPayment = dividendPayment.stream().filter(b->b!=null).<PendingPayment.PendingPaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDividendPayoutSequence()!=null && getDividendPayoutSequence().hasData()) return true;
			if (getDividendPayoutConditions()!=null) return true;
			if (getDividendPayment()!=null && getDividendPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPayout.DividendPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPayout.DividendPayoutBuilder o = (DividendPayout.DividendPayoutBuilder) other;
			
			merger.mergeRosetta(getDividendPayoutSequence(), o.getDividendPayoutSequence(), this::setDividendPayoutSequence);
			merger.mergeRosetta(getDividendPayment(), o.getDividendPayment(), this::getOrCreateDividendPayment);
			
			merger.mergeBasic(getDividendPayoutConditions(), o.getDividendPayoutConditions(), this::setDividendPayoutConditions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPayout _that = getType().cast(o);
		
			if (!Objects.equals(dividendPayoutSequence, _that.getDividendPayoutSequence())) return false;
			if (!Objects.equals(dividendPayoutConditions, _that.getDividendPayoutConditions())) return false;
			if (!ListEquals.listEquals(dividendPayment, _that.getDividendPayment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dividendPayoutSequence != null ? dividendPayoutSequence.hashCode() : 0);
			_result = 31 * _result + (dividendPayoutConditions != null ? dividendPayoutConditions.hashCode() : 0);
			_result = 31 * _result + (dividendPayment != null ? dividendPayment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPayoutBuilder {" +
				"dividendPayoutSequence=" + this.dividendPayoutSequence + ", " +
				"dividendPayoutConditions=" + this.dividendPayoutConditions + ", " +
				"dividendPayment=" + this.dividendPayment +
			'}';
		}
	}
}
