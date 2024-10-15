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
import fpml.confirmation.AbstractTradingAccrual;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilder;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl;
import fpml.confirmation.AbstractTradingAccrual.AbstractTradingAccrualImpl;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.LoanTradingAccruingFeeAccrual;
import fpml.confirmation.LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder;
import fpml.confirmation.LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilderImpl;
import fpml.confirmation.LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualImpl;
import fpml.confirmation.LoanTradingAccruingFeeTypeEnum;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.LoanTradingAccruingFeeAccrualMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that details the underlying elements that affect the calculation of a fee accrual.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradingAccruingFeeAccrual", builder=LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilderImpl.class, version="${project.version}")
public interface LoanTradingAccruingFeeAccrual extends AbstractTradingAccrual {

	LoanTradingAccruingFeeAccrualMeta metaData = new LoanTradingAccruingFeeAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique id associated with the loan accrual type.
	 */
	AccrualTypeId getAccrualTypeId();
	/**
	 * Describes the type of the accruing fee.
	 */
	LoanTradingAccruingFeeTypeEnum get_type();

	/*********************** Build Methods  ***********************/
	LoanTradingAccruingFeeAccrual build();
	
	LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder toBuilder();
	
	static LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder builder() {
		return new LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingAccruingFeeAccrual> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradingAccruingFeeAccrual> getType() {
		return LoanTradingAccruingFeeAccrual.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
		processRosetta(path.newSubPath("accrualTypeId"), processor, AccrualTypeId.class, getAccrualTypeId());
		processor.processBasic(path.newSubPath("_type"), LoanTradingAccruingFeeTypeEnum.class, get_type(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingAccruingFeeAccrualBuilder extends LoanTradingAccruingFeeAccrual, AbstractTradingAccrual.AbstractTradingAccrualBuilder {
		AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualTypeId();
		AccrualTypeId.AccrualTypeIdBuilder getAccrualTypeId();
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAmount(NonNegativeMoney amount);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod0);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod1, int _idx);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod2);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod3);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAccrualTypeId(AccrualTypeId accrualTypeId);
		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder set_type(LoanTradingAccruingFeeTypeEnum _type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
			processRosetta(path.newSubPath("accrualTypeId"), processor, AccrualTypeId.AccrualTypeIdBuilder.class, getAccrualTypeId());
			processor.processBasic(path.newSubPath("_type"), LoanTradingAccruingFeeTypeEnum.class, get_type(), this);
		}
		

		LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingAccruingFeeAccrual  ***********************/
	class LoanTradingAccruingFeeAccrualImpl extends AbstractTradingAccrual.AbstractTradingAccrualImpl implements LoanTradingAccruingFeeAccrual {
		private final AccrualTypeId accrualTypeId;
		private final LoanTradingAccruingFeeTypeEnum _type;
		
		protected LoanTradingAccruingFeeAccrualImpl(LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder builder) {
			super(builder);
			this.accrualTypeId = ofNullable(builder.getAccrualTypeId()).map(f->f.build()).orElse(null);
			this._type = builder.get_type();
		}
		
		@Override
		@RosettaAttribute("accrualTypeId")
		public AccrualTypeId getAccrualTypeId() {
			return accrualTypeId;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradingAccruingFeeTypeEnum get_type() {
			return _type;
		}
		
		@Override
		public LoanTradingAccruingFeeAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder toBuilder() {
			LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAccrualTypeId()).ifPresent(builder::setAccrualTypeId);
			ofNullable(get_type()).ifPresent(builder::set_type);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingAccruingFeeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(accrualTypeId, _that.getAccrualTypeId())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualTypeId != null ? accrualTypeId.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingAccruingFeeAccrual {" +
				"accrualTypeId=" + this.accrualTypeId + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradingAccruingFeeAccrual  ***********************/
	class LoanTradingAccruingFeeAccrualBuilderImpl extends AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl  implements LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder {
	
		protected AccrualTypeId.AccrualTypeIdBuilder accrualTypeId;
		protected LoanTradingAccruingFeeTypeEnum _type;
	
		public LoanTradingAccruingFeeAccrualBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accrualTypeId")
		public AccrualTypeId.AccrualTypeIdBuilder getAccrualTypeId() {
			return accrualTypeId;
		}
		
		@Override
		public AccrualTypeId.AccrualTypeIdBuilder getOrCreateAccrualTypeId() {
			AccrualTypeId.AccrualTypeIdBuilder result;
			if (accrualTypeId!=null) {
				result = accrualTypeId;
			}
			else {
				result = accrualTypeId = AccrualTypeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LoanTradingAccruingFeeTypeEnum get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("amount")
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod) {
			if (accrualPeriod!=null) this.accrualPeriod.add(accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int _idx) {
			getIndex(this.accrualPeriod, _idx, () -> accrualPeriod.toBuilder());
			return this;
		}
		@Override 
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("accrualPeriod")
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null)  {
				this.accrualPeriod = new ArrayList<>();
			}
			else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("accrualTypeId")
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder setAccrualTypeId(AccrualTypeId accrualTypeId) {
			this.accrualTypeId = accrualTypeId==null?null:accrualTypeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("_type")
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder set_type(LoanTradingAccruingFeeTypeEnum _type) {
			this._type = _type==null?null:_type;
			return this;
		}
		
		@Override
		public LoanTradingAccruingFeeAccrual build() {
			return new LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualImpl(this);
		}
		
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder prune() {
			super.prune();
			if (accrualTypeId!=null && !accrualTypeId.prune().hasData()) accrualTypeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAccrualTypeId()!=null && getAccrualTypeId().hasData()) return true;
			if (get_type()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder o = (LoanTradingAccruingFeeAccrual.LoanTradingAccruingFeeAccrualBuilder) other;
			
			merger.mergeRosetta(getAccrualTypeId(), o.getAccrualTypeId(), this::setAccrualTypeId);
			
			merger.mergeBasic(get_type(), o.get_type(), this::set_type);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradingAccruingFeeAccrual _that = getType().cast(o);
		
			if (!Objects.equals(accrualTypeId, _that.getAccrualTypeId())) return false;
			if (!Objects.equals(_type, _that.get_type())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (accrualTypeId != null ? accrualTypeId.hashCode() : 0);
			_result = 31 * _result + (_type != null ? _type.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingAccruingFeeAccrualBuilder {" +
				"accrualTypeId=" + this.accrualTypeId + ", " +
				"_type=" + this._type +
			'}' + " " + super.toString();
		}
	}
}
