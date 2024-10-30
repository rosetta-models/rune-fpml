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
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.CreditLimitUtilization.CreditLimitUtilizationBuilder;
import fpml.confirmation.CreditLimitUtilization.CreditLimitUtilizationBuilderImpl;
import fpml.confirmation.CreditLimitUtilization.CreditLimitUtilizationImpl;
import fpml.confirmation.CreditLimitUtilizationPosition;
import fpml.confirmation.meta.CreditLimitUtilizationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditLimitUtilization", builder=CreditLimitUtilization.CreditLimitUtilizationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditLimitUtilization extends RosettaModelObject {

	CreditLimitUtilizationMeta metaData = new CreditLimitUtilizationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Credit limit utilization attributable to executed trades.
	 */
	CreditLimitUtilizationPosition getExecuted();
	/**
	 * Credit limit utilization attributable to pending unexecuted orders.
	 */
	CreditLimitUtilizationPosition getPending();

	/*********************** Build Methods  ***********************/
	CreditLimitUtilization build();
	
	CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder();
	
	static CreditLimitUtilization.CreditLimitUtilizationBuilder builder() {
		return new CreditLimitUtilization.CreditLimitUtilizationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditLimitUtilization> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditLimitUtilization> getType() {
		return CreditLimitUtilization.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilizationPosition.class, getExecuted());
		processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilizationPosition.class, getPending());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditLimitUtilizationBuilder extends CreditLimitUtilization, RosettaModelObjectBuilder {
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreateExecuted();
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getExecuted();
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreatePending();
		CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getPending();
		CreditLimitUtilization.CreditLimitUtilizationBuilder setExecuted(CreditLimitUtilizationPosition executed);
		CreditLimitUtilization.CreditLimitUtilizationBuilder setPending(CreditLimitUtilizationPosition pending);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("executed"), processor, CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder.class, getExecuted());
			processRosetta(path.newSubPath("pending"), processor, CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder.class, getPending());
		}
		

		CreditLimitUtilization.CreditLimitUtilizationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditLimitUtilization  ***********************/
	class CreditLimitUtilizationImpl implements CreditLimitUtilization {
		private final CreditLimitUtilizationPosition executed;
		private final CreditLimitUtilizationPosition pending;
		
		protected CreditLimitUtilizationImpl(CreditLimitUtilization.CreditLimitUtilizationBuilder builder) {
			this.executed = ofNullable(builder.getExecuted()).map(f->f.build()).orElse(null);
			this.pending = ofNullable(builder.getPending()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("executed")
		public CreditLimitUtilizationPosition getExecuted() {
			return executed;
		}
		
		@Override
		@RosettaAttribute("pending")
		public CreditLimitUtilizationPosition getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilization build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder() {
			CreditLimitUtilization.CreditLimitUtilizationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilization.CreditLimitUtilizationBuilder builder) {
			ofNullable(getExecuted()).ifPresent(builder::setExecuted);
			ofNullable(getPending()).ifPresent(builder::setPending);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilization _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilization {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditLimitUtilization  ***********************/
	class CreditLimitUtilizationBuilderImpl implements CreditLimitUtilization.CreditLimitUtilizationBuilder {
	
		protected CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder executed;
		protected CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder pending;
	
		public CreditLimitUtilizationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("executed")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getExecuted() {
			return executed;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreateExecuted() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder result;
			if (executed!=null) {
				result = executed;
			}
			else {
				result = executed = CreditLimitUtilizationPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pending")
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getPending() {
			return pending;
		}
		
		@Override
		public CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder getOrCreatePending() {
			CreditLimitUtilizationPosition.CreditLimitUtilizationPositionBuilder result;
			if (pending!=null) {
				result = pending;
			}
			else {
				result = pending = CreditLimitUtilizationPosition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("executed")
		public CreditLimitUtilization.CreditLimitUtilizationBuilder setExecuted(CreditLimitUtilizationPosition executed) {
			this.executed = executed==null?null:executed.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pending")
		public CreditLimitUtilization.CreditLimitUtilizationBuilder setPending(CreditLimitUtilizationPosition pending) {
			this.pending = pending==null?null:pending.toBuilder();
			return this;
		}
		
		@Override
		public CreditLimitUtilization build() {
			return new CreditLimitUtilization.CreditLimitUtilizationImpl(this);
		}
		
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder prune() {
			if (executed!=null && !executed.prune().hasData()) executed = null;
			if (pending!=null && !pending.prune().hasData()) pending = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecuted()!=null && getExecuted().hasData()) return true;
			if (getPending()!=null && getPending().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilization.CreditLimitUtilizationBuilder o = (CreditLimitUtilization.CreditLimitUtilizationBuilder) other;
			
			merger.mergeRosetta(getExecuted(), o.getExecuted(), this::setExecuted);
			merger.mergeRosetta(getPending(), o.getPending(), this::setPending);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilization _that = getType().cast(o);
		
			if (!Objects.equals(executed, _that.getExecuted())) return false;
			if (!Objects.equals(pending, _that.getPending())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executed != null ? executed.hashCode() : 0);
			_result = 31 * _result + (pending != null ? pending.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilizationBuilder {" +
				"executed=" + this.executed + ", " +
				"pending=" + this.pending +
			'}';
		}
	}
}
