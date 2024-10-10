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
import fpml.confirmation.DSAKeyValueTypeSequence0;
import fpml.confirmation.DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder;
import fpml.confirmation.DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0BuilderImpl;
import fpml.confirmation.DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Impl;
import fpml.confirmation.meta.DSAKeyValueTypeSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DSAKeyValueTypeSequence0", builder=DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0BuilderImpl.class, version="${project.version}")
public interface DSAKeyValueTypeSequence0 extends RosettaModelObject {

	DSAKeyValueTypeSequence0Meta metaData = new DSAKeyValueTypeSequence0Meta();

	/*********************** Getter Methods  ***********************/
	String getP();
	String getQ();

	/*********************** Build Methods  ***********************/
	DSAKeyValueTypeSequence0 build();
	
	DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder toBuilder();
	
	static DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder builder() {
		return new DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValueTypeSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DSAKeyValueTypeSequence0> getType() {
		return DSAKeyValueTypeSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("p"), String.class, getP(), this);
		processor.processBasic(path.newSubPath("q"), String.class, getQ(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DSAKeyValueTypeSequence0Builder extends DSAKeyValueTypeSequence0, RosettaModelObjectBuilder {
		DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder setP(String p);
		DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder setQ(String q);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("p"), String.class, getP(), this);
			processor.processBasic(path.newSubPath("q"), String.class, getQ(), this);
		}
		

		DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValueTypeSequence0  ***********************/
	class DSAKeyValueTypeSequence0Impl implements DSAKeyValueTypeSequence0 {
		private final String p;
		private final String q;
		
		protected DSAKeyValueTypeSequence0Impl(DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder builder) {
			this.p = builder.getP();
			this.q = builder.getQ();
		}
		
		@Override
		@RosettaAttribute("p")
		public String getP() {
			return p;
		}
		
		@Override
		@RosettaAttribute("q")
		public String getQ() {
			return q;
		}
		
		@Override
		public DSAKeyValueTypeSequence0 build() {
			return this;
		}
		
		@Override
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder toBuilder() {
			DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder builder) {
			ofNullable(getP()).ifPresent(builder::setP);
			ofNullable(getQ()).ifPresent(builder::setQ);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueTypeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(p, _that.getP())) return false;
			if (!Objects.equals(q, _that.getQ())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (p != null ? p.hashCode() : 0);
			_result = 31 * _result + (q != null ? q.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeSequence0 {" +
				"p=" + this.p + ", " +
				"q=" + this.q +
			'}';
		}
	}

	/*********************** Builder Implementation of DSAKeyValueTypeSequence0  ***********************/
	class DSAKeyValueTypeSequence0BuilderImpl implements DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder {
	
		protected String p;
		protected String q;
	
		public DSAKeyValueTypeSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("p")
		public String getP() {
			return p;
		}
		
		@Override
		@RosettaAttribute("q")
		public String getQ() {
			return q;
		}
		
		@Override
		@RosettaAttribute("p")
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder setP(String p) {
			this.p = p==null?null:p;
			return this;
		}
		@Override
		@RosettaAttribute("q")
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder setQ(String q) {
			this.q = q==null?null:q;
			return this;
		}
		
		@Override
		public DSAKeyValueTypeSequence0 build() {
			return new DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Impl(this);
		}
		
		@Override
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getP()!=null) return true;
			if (getQ()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder o = (DSAKeyValueTypeSequence0.DSAKeyValueTypeSequence0Builder) other;
			
			
			merger.mergeBasic(getP(), o.getP(), this::setP);
			merger.mergeBasic(getQ(), o.getQ(), this::setQ);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueTypeSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(p, _that.getP())) return false;
			if (!Objects.equals(q, _that.getQ())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (p != null ? p.hashCode() : 0);
			_result = 31 * _result + (q != null ? q.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeSequence0Builder {" +
				"p=" + this.p + ", " +
				"q=" + this.q +
			'}';
		}
	}
}
