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
import fpml.confirmation.AccrualOptionBase;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseBuilder;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseBuilderImpl;
import fpml.confirmation.AccrualOptionBase.AccrualOptionBaseImpl;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateIndexLoanModel;
import fpml.confirmation.FloatingRateOptionBase;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilder;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl;
import fpml.confirmation.FloatingRateOptionBase.FloatingRateOptionBaseImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FloatingRateOptionBaseMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An abstract type that specifies an underlying floating rate cash accrual option.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateOptionBase", builder=FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl.class, version="${project.version}")
public interface FloatingRateOptionBase extends AccrualOptionBase {

	FloatingRateOptionBaseMeta metaData = new FloatingRateOptionBaseMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexLoanModel getFloatingRateIndexLoanModel();
	BigDecimal getSpread();
	BigDecimal getPikSpread();

	/*********************** Build Methods  ***********************/
	FloatingRateOptionBase build();
	
	FloatingRateOptionBase.FloatingRateOptionBaseBuilder toBuilder();
	
	static FloatingRateOptionBase.FloatingRateOptionBaseBuilder builder() {
		return new FloatingRateOptionBase.FloatingRateOptionBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateOptionBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRateOptionBase> getType() {
		return FloatingRateOptionBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.class, getAccrualOptionId());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
		processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.class, getFloatingRateIndexLoanModel());
		processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
		processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateOptionBaseBuilder extends FloatingRateOptionBase, AccrualOptionBase.AccrualOptionBaseBuilder {
		FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder getOrCreateFloatingRateIndexLoanModel();
		FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder getFloatingRateIndexLoanModel();
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId);
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency);
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel);
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setSpread(BigDecimal spread);
		FloatingRateOptionBase.FloatingRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accrualOptionId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualOptionId());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
			processRosetta(path.newSubPath("floatingRateIndexLoanModel"), processor, FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder.class, getFloatingRateIndexLoanModel());
			processor.processBasic(path.newSubPath("spread"), BigDecimal.class, getSpread(), this);
			processor.processBasic(path.newSubPath("pikSpread"), BigDecimal.class, getPikSpread(), this);
		}
		

		FloatingRateOptionBase.FloatingRateOptionBaseBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateOptionBase  ***********************/
	class FloatingRateOptionBaseImpl extends AccrualOptionBase.AccrualOptionBaseImpl implements FloatingRateOptionBase {
		private final FloatingRateIndexLoanModel floatingRateIndexLoanModel;
		private final BigDecimal spread;
		private final BigDecimal pikSpread;
		
		protected FloatingRateOptionBaseImpl(FloatingRateOptionBase.FloatingRateOptionBaseBuilder builder) {
			super(builder);
			this.floatingRateIndexLoanModel = ofNullable(builder.getFloatingRateIndexLoanModel()).map(f->f.build()).orElse(null);
			this.spread = builder.getSpread();
			this.pikSpread = builder.getPikSpread();
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexLoanModel")
		public FloatingRateIndexLoanModel getFloatingRateIndexLoanModel() {
			return floatingRateIndexLoanModel;
		}
		
		@Override
		@RosettaAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		public FloatingRateOptionBase build() {
			return this;
		}
		
		@Override
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder toBuilder() {
			FloatingRateOptionBase.FloatingRateOptionBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateOptionBase.FloatingRateOptionBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndexLoanModel()).ifPresent(builder::setFloatingRateIndexLoanModel);
			ofNullable(getSpread()).ifPresent(builder::setSpread);
			ofNullable(getPikSpread()).ifPresent(builder::setPikSpread);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexLoanModel, _that.getFloatingRateIndexLoanModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndexLoanModel != null ? floatingRateIndexLoanModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionBase {" +
				"floatingRateIndexLoanModel=" + this.floatingRateIndexLoanModel + ", " +
				"spread=" + this.spread + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRateOptionBase  ***********************/
	class FloatingRateOptionBaseBuilderImpl extends AccrualOptionBase.AccrualOptionBaseBuilderImpl  implements FloatingRateOptionBase.FloatingRateOptionBaseBuilder {
	
		protected FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder floatingRateIndexLoanModel;
		protected BigDecimal spread;
		protected BigDecimal pikSpread;
	
		public FloatingRateOptionBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndexLoanModel")
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder getFloatingRateIndexLoanModel() {
			return floatingRateIndexLoanModel;
		}
		
		@Override
		public FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder getOrCreateFloatingRateIndexLoanModel() {
			FloatingRateIndexLoanModel.FloatingRateIndexLoanModelBuilder result;
			if (floatingRateIndexLoanModel!=null) {
				result = floatingRateIndexLoanModel;
			}
			else {
				result = floatingRateIndexLoanModel = FloatingRateIndexLoanModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spread")
		public BigDecimal getSpread() {
			return spread;
		}
		
		@Override
		@RosettaAttribute("pikSpread")
		public BigDecimal getPikSpread() {
			return pikSpread;
		}
		
		@Override
		@RosettaAttribute("accrualOptionId")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setAccrualOptionId(AccrualTypeId accrualOptionId) {
			this.accrualOptionId = accrualOptionId==null?null:accrualOptionId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexLoanModel")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setFloatingRateIndexLoanModel(FloatingRateIndexLoanModel floatingRateIndexLoanModel) {
			this.floatingRateIndexLoanModel = floatingRateIndexLoanModel==null?null:floatingRateIndexLoanModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spread")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setSpread(BigDecimal spread) {
			this.spread = spread==null?null:spread;
			return this;
		}
		@Override
		@RosettaAttribute("pikSpread")
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder setPikSpread(BigDecimal pikSpread) {
			this.pikSpread = pikSpread==null?null:pikSpread;
			return this;
		}
		
		@Override
		public FloatingRateOptionBase build() {
			return new FloatingRateOptionBase.FloatingRateOptionBaseImpl(this);
		}
		
		@Override
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder prune() {
			super.prune();
			if (floatingRateIndexLoanModel!=null && !floatingRateIndexLoanModel.prune().hasData()) floatingRateIndexLoanModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndexLoanModel()!=null && getFloatingRateIndexLoanModel().hasData()) return true;
			if (getSpread()!=null) return true;
			if (getPikSpread()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateOptionBase.FloatingRateOptionBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRateOptionBase.FloatingRateOptionBaseBuilder o = (FloatingRateOptionBase.FloatingRateOptionBaseBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndexLoanModel(), o.getFloatingRateIndexLoanModel(), this::setFloatingRateIndexLoanModel);
			
			merger.mergeBasic(getSpread(), o.getSpread(), this::setSpread);
			merger.mergeBasic(getPikSpread(), o.getPikSpread(), this::setPikSpread);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRateOptionBase _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexLoanModel, _that.getFloatingRateIndexLoanModel())) return false;
			if (!Objects.equals(spread, _that.getSpread())) return false;
			if (!Objects.equals(pikSpread, _that.getPikSpread())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndexLoanModel != null ? floatingRateIndexLoanModel.hashCode() : 0);
			_result = 31 * _result + (spread != null ? spread.hashCode() : 0);
			_result = 31 * _result + (pikSpread != null ? pikSpread.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateOptionBaseBuilder {" +
				"floatingRateIndexLoanModel=" + this.floatingRateIndexLoanModel + ", " +
				"spread=" + this.spread + ", " +
				"pikSpread=" + this.pikSpread +
			'}' + " " + super.toString();
		}
	}
}
