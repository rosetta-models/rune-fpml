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
import fpml.confirmation.NetAndOrGrossModelSequence;
import fpml.confirmation.NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder;
import fpml.confirmation.NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilderImpl;
import fpml.confirmation.NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceImpl;
import fpml.confirmation.meta.NetAndOrGrossModelSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NetAndOrGrossModelSequence", builder=NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilderImpl.class, version="${project.version}")
public interface NetAndOrGrossModelSequence extends RosettaModelObject {

	NetAndOrGrossModelSequenceMeta metaData = new NetAndOrGrossModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value including fees and commissions.
	 */
	BigDecimal getGross();
	/**
	 * Value excluding fees and commissions.
	 */
	BigDecimal getNet();

	/*********************** Build Methods  ***********************/
	NetAndOrGrossModelSequence build();
	
	NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder toBuilder();
	
	static NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder builder() {
		return new NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NetAndOrGrossModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NetAndOrGrossModelSequence> getType() {
		return NetAndOrGrossModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("gross"), BigDecimal.class, getGross(), this);
		processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NetAndOrGrossModelSequenceBuilder extends NetAndOrGrossModelSequence, RosettaModelObjectBuilder {
		NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder setGross(BigDecimal gross);
		NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder setNet(BigDecimal net);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("gross"), BigDecimal.class, getGross(), this);
			processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
		}
		

		NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of NetAndOrGrossModelSequence  ***********************/
	class NetAndOrGrossModelSequenceImpl implements NetAndOrGrossModelSequence {
		private final BigDecimal gross;
		private final BigDecimal net;
		
		protected NetAndOrGrossModelSequenceImpl(NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder builder) {
			this.gross = builder.getGross();
			this.net = builder.getNet();
		}
		
		@Override
		@RosettaAttribute("gross")
		public BigDecimal getGross() {
			return gross;
		}
		
		@Override
		@RosettaAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		public NetAndOrGrossModelSequence build() {
			return this;
		}
		
		@Override
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder toBuilder() {
			NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder builder) {
			ofNullable(getGross()).ifPresent(builder::setGross);
			ofNullable(getNet()).ifPresent(builder::setNet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndOrGrossModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(gross, _that.getGross())) return false;
			if (!Objects.equals(net, _that.getNet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (gross != null ? gross.hashCode() : 0);
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndOrGrossModelSequence {" +
				"gross=" + this.gross + ", " +
				"net=" + this.net +
			'}';
		}
	}

	/*********************** Builder Implementation of NetAndOrGrossModelSequence  ***********************/
	class NetAndOrGrossModelSequenceBuilderImpl implements NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder {
	
		protected BigDecimal gross;
		protected BigDecimal net;
	
		public NetAndOrGrossModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("gross")
		public BigDecimal getGross() {
			return gross;
		}
		
		@Override
		@RosettaAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		@RosettaAttribute("gross")
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder setGross(BigDecimal gross) {
			this.gross = gross==null?null:gross;
			return this;
		}
		@Override
		@RosettaAttribute("net")
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder setNet(BigDecimal net) {
			this.net = net==null?null:net;
			return this;
		}
		
		@Override
		public NetAndOrGrossModelSequence build() {
			return new NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceImpl(this);
		}
		
		@Override
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGross()!=null) return true;
			if (getNet()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder o = (NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder) other;
			
			
			merger.mergeBasic(getGross(), o.getGross(), this::setGross);
			merger.mergeBasic(getNet(), o.getNet(), this::setNet);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndOrGrossModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(gross, _that.getGross())) return false;
			if (!Objects.equals(net, _that.getNet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (gross != null ? gross.hashCode() : 0);
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndOrGrossModelSequenceBuilder {" +
				"gross=" + this.gross + ", " +
				"net=" + this.net +
			'}';
		}
	}
}
