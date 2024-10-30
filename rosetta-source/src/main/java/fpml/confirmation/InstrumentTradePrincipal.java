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
import fpml.confirmation.InstrumentTradePrincipal;
import fpml.confirmation.InstrumentTradePrincipal.InstrumentTradePrincipalBuilder;
import fpml.confirmation.InstrumentTradePrincipal.InstrumentTradePrincipalBuilderImpl;
import fpml.confirmation.InstrumentTradePrincipal.InstrumentTradePrincipalImpl;
import fpml.confirmation.NetAndGross;
import fpml.confirmation.meta.InstrumentTradePrincipalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure describing the value in &quot;native&quot; currency of an instrument that was traded.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InstrumentTradePrincipal", builder=InstrumentTradePrincipal.InstrumentTradePrincipalBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InstrumentTradePrincipal extends RosettaModelObject {

	InstrumentTradePrincipalMeta metaData = new InstrumentTradePrincipalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The net and/or gross value of the amount traded in native currency.
	 */
	NetAndGross getPrincipalAmount();

	/*********************** Build Methods  ***********************/
	InstrumentTradePrincipal build();
	
	InstrumentTradePrincipal.InstrumentTradePrincipalBuilder toBuilder();
	
	static InstrumentTradePrincipal.InstrumentTradePrincipalBuilder builder() {
		return new InstrumentTradePrincipal.InstrumentTradePrincipalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradePrincipal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentTradePrincipal> getType() {
		return InstrumentTradePrincipal.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("principalAmount"), processor, NetAndGross.class, getPrincipalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradePrincipalBuilder extends InstrumentTradePrincipal, RosettaModelObjectBuilder {
		NetAndGross.NetAndGrossBuilder getOrCreatePrincipalAmount();
		NetAndGross.NetAndGrossBuilder getPrincipalAmount();
		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder setPrincipalAmount(NetAndGross principalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("principalAmount"), processor, NetAndGross.NetAndGrossBuilder.class, getPrincipalAmount());
		}
		

		InstrumentTradePrincipal.InstrumentTradePrincipalBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradePrincipal  ***********************/
	class InstrumentTradePrincipalImpl implements InstrumentTradePrincipal {
		private final NetAndGross principalAmount;
		
		protected InstrumentTradePrincipalImpl(InstrumentTradePrincipal.InstrumentTradePrincipalBuilder builder) {
			this.principalAmount = ofNullable(builder.getPrincipalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		public NetAndGross getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public InstrumentTradePrincipal build() {
			return this;
		}
		
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder toBuilder() {
			InstrumentTradePrincipal.InstrumentTradePrincipalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradePrincipal.InstrumentTradePrincipalBuilder builder) {
			ofNullable(getPrincipalAmount()).ifPresent(builder::setPrincipalAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePrincipal _that = getType().cast(o);
		
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePrincipal {" +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentTradePrincipal  ***********************/
	class InstrumentTradePrincipalBuilderImpl implements InstrumentTradePrincipal.InstrumentTradePrincipalBuilder {
	
		protected NetAndGross.NetAndGrossBuilder principalAmount;
	
		public InstrumentTradePrincipalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("principalAmount")
		public NetAndGross.NetAndGrossBuilder getPrincipalAmount() {
			return principalAmount;
		}
		
		@Override
		public NetAndGross.NetAndGrossBuilder getOrCreatePrincipalAmount() {
			NetAndGross.NetAndGrossBuilder result;
			if (principalAmount!=null) {
				result = principalAmount;
			}
			else {
				result = principalAmount = NetAndGross.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalAmount")
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder setPrincipalAmount(NetAndGross principalAmount) {
			this.principalAmount = principalAmount==null?null:principalAmount.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentTradePrincipal build() {
			return new InstrumentTradePrincipal.InstrumentTradePrincipalImpl(this);
		}
		
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder prune() {
			if (principalAmount!=null && !principalAmount.prune().hasData()) principalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrincipalAmount()!=null && getPrincipalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePrincipal.InstrumentTradePrincipalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentTradePrincipal.InstrumentTradePrincipalBuilder o = (InstrumentTradePrincipal.InstrumentTradePrincipalBuilder) other;
			
			merger.mergeRosetta(getPrincipalAmount(), o.getPrincipalAmount(), this::setPrincipalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePrincipal _that = getType().cast(o);
		
			if (!Objects.equals(principalAmount, _that.getPrincipalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalAmount != null ? principalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePrincipalBuilder {" +
				"principalAmount=" + this.principalAmount +
			'}';
		}
	}
}
