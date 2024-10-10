package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CompoundingFrequency;
import fpml.confirmation.validation.CompoundingFrequencyTypeFormatValidator;
import fpml.confirmation.validation.CompoundingFrequencyValidator;
import fpml.confirmation.validation.exists.CompoundingFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CompoundingFrequency.class)
public class CompoundingFrequencyMeta implements RosettaMetaData<CompoundingFrequency> {

	@Override
	public List<Validator<? super CompoundingFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CompoundingFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CompoundingFrequency> validator() {
		return new CompoundingFrequencyValidator();
	}

	@Override
	public Validator<? super CompoundingFrequency> typeFormatValidator() {
		return new CompoundingFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompoundingFrequency, Set<String>> onlyExistsValidator() {
		return new CompoundingFrequencyOnlyExistsValidator();
	}
}
