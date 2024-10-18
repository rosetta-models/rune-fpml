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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.Money;
import fpml.confirmation.Stub;
import fpml.confirmation.Stub.StubBuilder;
import fpml.confirmation.Stub.StubBuilderImpl;
import fpml.confirmation.Stub.StubImpl;
import fpml.confirmation.StubFloatingRate;
import fpml.confirmation.StubValue;
import fpml.confirmation.StubValue.StubValueBuilder;
import fpml.confirmation.StubValue.StubValueBuilderImpl;
import fpml.confirmation.StubValue.StubValueImpl;
import fpml.confirmation.meta.StubMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining how a stub calculation period amount is calculated and the start and end date of the stub. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating rate tenors many be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3 Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
 * @version ${project.version}
 */
@RosettaDataType(value="Stub", builder=Stub.StubBuilderImpl.class, version="${project.version}")
public interface Stub extends StubValue {

	StubMeta metaData = new StubMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Start date of stub period. This was created to support use of the InterestRateStream within the Equity Derivative sphere, and this element is not expected to be produced in the representation of Interest Rate products.
	 */
	AdjustableOrRelativeDate getStubStartDate();
	/**
	 * End date of stub period. This was created to support use of the InterestRateStream within the Equity Derivative sphere, and this element is not expected to be produced in the representation of Interest Rate products.
	 */
	AdjustableOrRelativeDate getStubEndDate();

	/*********************** Build Methods  ***********************/
	Stub build();
	
	Stub.StubBuilder toBuilder();
	
	static Stub.StubBuilder builder() {
		return new Stub.StubBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Stub> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Stub> getType() {
		return Stub.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRate"), processor, StubFloatingRate.class, getFloatingRate());
		processor.processBasic(path.newSubPath("stubRate"), BigDecimal.class, getStubRate(), this);
		processRosetta(path.newSubPath("stubAmount"), processor, Money.class, getStubAmount());
		processRosetta(path.newSubPath("stubStartDate"), processor, AdjustableOrRelativeDate.class, getStubStartDate());
		processRosetta(path.newSubPath("stubEndDate"), processor, AdjustableOrRelativeDate.class, getStubEndDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubBuilder extends Stub, StubValue.StubValueBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStubStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStubStartDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStubEndDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStubEndDate();
		Stub.StubBuilder addFloatingRate(StubFloatingRate floatingRate0);
		Stub.StubBuilder addFloatingRate(StubFloatingRate floatingRate1, int _idx);
		Stub.StubBuilder addFloatingRate(List<? extends StubFloatingRate> floatingRate2);
		Stub.StubBuilder setFloatingRate(List<? extends StubFloatingRate> floatingRate3);
		Stub.StubBuilder setStubRate(BigDecimal stubRate);
		Stub.StubBuilder setStubAmount(Money stubAmount);
		Stub.StubBuilder setStubStartDate(AdjustableOrRelativeDate stubStartDate);
		Stub.StubBuilder setStubEndDate(AdjustableOrRelativeDate stubEndDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRate"), processor, StubFloatingRate.StubFloatingRateBuilder.class, getFloatingRate());
			processor.processBasic(path.newSubPath("stubRate"), BigDecimal.class, getStubRate(), this);
			processRosetta(path.newSubPath("stubAmount"), processor, Money.MoneyBuilder.class, getStubAmount());
			processRosetta(path.newSubPath("stubStartDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStubStartDate());
			processRosetta(path.newSubPath("stubEndDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getStubEndDate());
		}
		

		Stub.StubBuilder prune();
	}

	/*********************** Immutable Implementation of Stub  ***********************/
	class StubImpl extends StubValue.StubValueImpl implements Stub {
		private final AdjustableOrRelativeDate stubStartDate;
		private final AdjustableOrRelativeDate stubEndDate;
		
		protected StubImpl(Stub.StubBuilder builder) {
			super(builder);
			this.stubStartDate = ofNullable(builder.getStubStartDate()).map(f->f.build()).orElse(null);
			this.stubEndDate = ofNullable(builder.getStubEndDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("stubStartDate")
		public AdjustableOrRelativeDate getStubStartDate() {
			return stubStartDate;
		}
		
		@Override
		@RosettaAttribute("stubEndDate")
		public AdjustableOrRelativeDate getStubEndDate() {
			return stubEndDate;
		}
		
		@Override
		public Stub build() {
			return this;
		}
		
		@Override
		public Stub.StubBuilder toBuilder() {
			Stub.StubBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Stub.StubBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStubStartDate()).ifPresent(builder::setStubStartDate);
			ofNullable(getStubEndDate()).ifPresent(builder::setStubEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Stub _that = getType().cast(o);
		
			if (!Objects.equals(stubStartDate, _that.getStubStartDate())) return false;
			if (!Objects.equals(stubEndDate, _that.getStubEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stubStartDate != null ? stubStartDate.hashCode() : 0);
			_result = 31 * _result + (stubEndDate != null ? stubEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Stub {" +
				"stubStartDate=" + this.stubStartDate + ", " +
				"stubEndDate=" + this.stubEndDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Stub  ***********************/
	class StubBuilderImpl extends StubValue.StubValueBuilderImpl  implements Stub.StubBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder stubStartDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder stubEndDate;
	
		public StubBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("stubStartDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStubStartDate() {
			return stubStartDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStubStartDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (stubStartDate!=null) {
				result = stubStartDate;
			}
			else {
				result = stubStartDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stubEndDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getStubEndDate() {
			return stubEndDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateStubEndDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (stubEndDate!=null) {
				result = stubEndDate;
			}
			else {
				result = stubEndDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRate")
		public Stub.StubBuilder addFloatingRate(StubFloatingRate floatingRate) {
			if (floatingRate!=null) this.floatingRate.add(floatingRate.toBuilder());
			return this;
		}
		
		@Override
		public Stub.StubBuilder addFloatingRate(StubFloatingRate floatingRate, int _idx) {
			getIndex(this.floatingRate, _idx, () -> floatingRate.toBuilder());
			return this;
		}
		@Override 
		public Stub.StubBuilder addFloatingRate(List<? extends StubFloatingRate> floatingRates) {
			if (floatingRates != null) {
				for (StubFloatingRate toAdd : floatingRates) {
					this.floatingRate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Stub.StubBuilder setFloatingRate(List<? extends StubFloatingRate> floatingRates) {
			if (floatingRates == null)  {
				this.floatingRate = new ArrayList<>();
			}
			else {
				this.floatingRate = floatingRates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("stubRate")
		public Stub.StubBuilder setStubRate(BigDecimal stubRate) {
			this.stubRate = stubRate==null?null:stubRate;
			return this;
		}
		@Override
		@RosettaAttribute("stubAmount")
		public Stub.StubBuilder setStubAmount(Money stubAmount) {
			this.stubAmount = stubAmount==null?null:stubAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("stubStartDate")
		public Stub.StubBuilder setStubStartDate(AdjustableOrRelativeDate stubStartDate) {
			this.stubStartDate = stubStartDate==null?null:stubStartDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("stubEndDate")
		public Stub.StubBuilder setStubEndDate(AdjustableOrRelativeDate stubEndDate) {
			this.stubEndDate = stubEndDate==null?null:stubEndDate.toBuilder();
			return this;
		}
		
		@Override
		public Stub build() {
			return new Stub.StubImpl(this);
		}
		
		@Override
		public Stub.StubBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Stub.StubBuilder prune() {
			super.prune();
			if (stubStartDate!=null && !stubStartDate.prune().hasData()) stubStartDate = null;
			if (stubEndDate!=null && !stubEndDate.prune().hasData()) stubEndDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStubStartDate()!=null && getStubStartDate().hasData()) return true;
			if (getStubEndDate()!=null && getStubEndDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Stub.StubBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Stub.StubBuilder o = (Stub.StubBuilder) other;
			
			merger.mergeRosetta(getStubStartDate(), o.getStubStartDate(), this::setStubStartDate);
			merger.mergeRosetta(getStubEndDate(), o.getStubEndDate(), this::setStubEndDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Stub _that = getType().cast(o);
		
			if (!Objects.equals(stubStartDate, _that.getStubStartDate())) return false;
			if (!Objects.equals(stubEndDate, _that.getStubEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (stubStartDate != null ? stubStartDate.hashCode() : 0);
			_result = 31 * _result + (stubEndDate != null ? stubEndDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubBuilder {" +
				"stubStartDate=" + this.stubStartDate + ", " +
				"stubEndDate=" + this.stubEndDate +
			'}' + " " + super.toString();
		}
	}
}
