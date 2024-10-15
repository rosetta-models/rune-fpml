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
import fpml.confirmation.MatchId;
import fpml.confirmation.MatchId.MatchIdBuilder;
import fpml.confirmation.MatchId.MatchIdBuilderImpl;
import fpml.confirmation.MatchId.MatchIdImpl;
import fpml.confirmation.meta.MatchIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An identifier used to identify matched cashflows.
 * @version ${project.version}
 */
@RosettaDataType(value="MatchId", builder=MatchId.MatchIdBuilderImpl.class, version="${project.version}")
public interface MatchId extends RosettaModelObject {

	MatchIdMeta metaData = new MatchIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getMatchIdScheme();

	/*********************** Build Methods  ***********************/
	MatchId build();
	
	MatchId.MatchIdBuilder toBuilder();
	
	static MatchId.MatchIdBuilder builder() {
		return new MatchId.MatchIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MatchId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MatchId> getType() {
		return MatchId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("matchIdScheme"), String.class, getMatchIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MatchIdBuilder extends MatchId, RosettaModelObjectBuilder {
		MatchId.MatchIdBuilder setValue(String value);
		MatchId.MatchIdBuilder setMatchIdScheme(String matchIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("matchIdScheme"), String.class, getMatchIdScheme(), this);
		}
		

		MatchId.MatchIdBuilder prune();
	}

	/*********************** Immutable Implementation of MatchId  ***********************/
	class MatchIdImpl implements MatchId {
		private final String value;
		private final String matchIdScheme;
		
		protected MatchIdImpl(MatchId.MatchIdBuilder builder) {
			this.value = builder.getValue();
			this.matchIdScheme = builder.getMatchIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matchIdScheme")
		public String getMatchIdScheme() {
			return matchIdScheme;
		}
		
		@Override
		public MatchId build() {
			return this;
		}
		
		@Override
		public MatchId.MatchIdBuilder toBuilder() {
			MatchId.MatchIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MatchId.MatchIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMatchIdScheme()).ifPresent(builder::setMatchIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatchId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matchIdScheme, _that.getMatchIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matchIdScheme != null ? matchIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatchId {" +
				"value=" + this.value + ", " +
				"matchIdScheme=" + this.matchIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MatchId  ***********************/
	class MatchIdBuilderImpl implements MatchId.MatchIdBuilder {
	
		protected String value;
		protected String matchIdScheme;
	
		public MatchIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("matchIdScheme")
		public String getMatchIdScheme() {
			return matchIdScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public MatchId.MatchIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("matchIdScheme")
		public MatchId.MatchIdBuilder setMatchIdScheme(String matchIdScheme) {
			this.matchIdScheme = matchIdScheme==null?null:matchIdScheme;
			return this;
		}
		
		@Override
		public MatchId build() {
			return new MatchId.MatchIdImpl(this);
		}
		
		@Override
		public MatchId.MatchIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatchId.MatchIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMatchIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatchId.MatchIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MatchId.MatchIdBuilder o = (MatchId.MatchIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMatchIdScheme(), o.getMatchIdScheme(), this::setMatchIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatchId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(matchIdScheme, _that.getMatchIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (matchIdScheme != null ? matchIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatchIdBuilder {" +
				"value=" + this.value + ", " +
				"matchIdScheme=" + this.matchIdScheme +
			'}';
		}
	}
}
