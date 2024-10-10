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
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.LoanInterestPaymentSequence;
import fpml.confirmation.LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder;
import fpml.confirmation.LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilderImpl;
import fpml.confirmation.LoanInterestPaymentSequence.LoanInterestPaymentSequenceImpl;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.meta.LoanInterestPaymentSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanInterestPaymentSequence", builder=LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilderImpl.class, version="${project.version}")
public interface LoanInterestPaymentSequence extends RosettaModelObject {

	LoanInterestPaymentSequenceMeta metaData = new LoanInterestPaymentSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A schedule that incorporates all sub-periods of an accrual calculation.
	 */
	List<? extends AccrualPeriod> getAccrualSchedule();
	/**
	 * Projected interest payment details.
	 */
	PaymentProjection getProjection();

	/*********************** Build Methods  ***********************/
	LoanInterestPaymentSequence build();
	
	LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder toBuilder();
	
	static LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder builder() {
		return new LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanInterestPaymentSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanInterestPaymentSequence> getType() {
		return LoanInterestPaymentSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.class, getAccrualSchedule());
		processRosetta(path.newSubPath("projection"), processor, PaymentProjection.class, getProjection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanInterestPaymentSequenceBuilder extends LoanInterestPaymentSequence, RosettaModelObjectBuilder {
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index);
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule();
		PaymentProjection.PaymentProjectionBuilder getOrCreateProjection();
		PaymentProjection.PaymentProjectionBuilder getProjection();
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule0);
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule1, int _idx);
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule2);
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedule3);
		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder setProjection(PaymentProjection projection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualSchedule"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualSchedule());
			processRosetta(path.newSubPath("projection"), processor, PaymentProjection.PaymentProjectionBuilder.class, getProjection());
		}
		

		LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanInterestPaymentSequence  ***********************/
	class LoanInterestPaymentSequenceImpl implements LoanInterestPaymentSequence {
		private final List<? extends AccrualPeriod> accrualSchedule;
		private final PaymentProjection projection;
		
		protected LoanInterestPaymentSequenceImpl(LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder builder) {
			this.accrualSchedule = ofNullable(builder.getAccrualSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.projection = ofNullable(builder.getProjection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		@Override
		@RosettaAttribute("projection")
		public PaymentProjection getProjection() {
			return projection;
		}
		
		@Override
		public LoanInterestPaymentSequence build() {
			return this;
		}
		
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder toBuilder() {
			LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder builder) {
			ofNullable(getAccrualSchedule()).ifPresent(builder::setAccrualSchedule);
			ofNullable(getProjection()).ifPresent(builder::setProjection);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanInterestPaymentSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPaymentSequence {" +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanInterestPaymentSequence  ***********************/
	class LoanInterestPaymentSequenceBuilderImpl implements LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder {
	
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualSchedule = new ArrayList<>();
		protected PaymentProjection.PaymentProjectionBuilder projection;
	
		public LoanInterestPaymentSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualSchedule")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualSchedule() {
			return accrualSchedule;
		}
		
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualSchedule(int _index) {
		
			if (accrualSchedule==null) {
				this.accrualSchedule = new ArrayList<>();
			}
			AccrualPeriod.AccrualPeriodBuilder result;
			return getIndex(accrualSchedule, _index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualSchedule = AccrualPeriod.builder();
						return newAccrualSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("projection")
		public PaymentProjection.PaymentProjectionBuilder getProjection() {
			return projection;
		}
		
		@Override
		public PaymentProjection.PaymentProjectionBuilder getOrCreateProjection() {
			PaymentProjection.PaymentProjectionBuilder result;
			if (projection!=null) {
				result = projection;
			}
			else {
				result = projection = PaymentProjection.builder();
			}
			
			return result;
		}
		
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule) {
			if (accrualSchedule!=null) this.accrualSchedule.add(accrualSchedule.toBuilder());
			return this;
		}
		
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(AccrualPeriod accrualSchedule, int _idx) {
			getIndex(this.accrualSchedule, _idx, () -> accrualSchedule.toBuilder());
			return this;
		}
		@Override 
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder addAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules != null) {
				for (AccrualPeriod toAdd : accrualSchedules) {
					this.accrualSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualSchedule")
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder setAccrualSchedule(List<? extends AccrualPeriod> accrualSchedules) {
			if (accrualSchedules == null)  {
				this.accrualSchedule = new ArrayList<>();
			}
			else {
				this.accrualSchedule = accrualSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("projection")
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder setProjection(PaymentProjection projection) {
			this.projection = projection==null?null:projection.toBuilder();
			return this;
		}
		
		@Override
		public LoanInterestPaymentSequence build() {
			return new LoanInterestPaymentSequence.LoanInterestPaymentSequenceImpl(this);
		}
		
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder prune() {
			accrualSchedule = accrualSchedule.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (projection!=null && !projection.prune().hasData()) projection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccrualSchedule()!=null && getAccrualSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getProjection()!=null && getProjection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder o = (LoanInterestPaymentSequence.LoanInterestPaymentSequenceBuilder) other;
			
			merger.mergeRosetta(getAccrualSchedule(), o.getAccrualSchedule(), this::getOrCreateAccrualSchedule);
			merger.mergeRosetta(getProjection(), o.getProjection(), this::setProjection);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanInterestPaymentSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accrualSchedule, _that.getAccrualSchedule())) return false;
			if (!Objects.equals(projection, _that.getProjection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accrualSchedule != null ? accrualSchedule.hashCode() : 0);
			_result = 31 * _result + (projection != null ? projection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanInterestPaymentSequenceBuilder {" +
				"accrualSchedule=" + this.accrualSchedule + ", " +
				"projection=" + this.projection +
			'}';
		}
	}
}
