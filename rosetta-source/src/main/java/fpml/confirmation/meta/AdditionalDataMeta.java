package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalData;
import fpml.confirmation.validation.AdditionalDataTypeFormatValidator;
import fpml.confirmation.validation.AdditionalDataValidator;
import fpml.confirmation.validation.exists.AdditionalDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdditionalData.class)
public class AdditionalDataMeta implements RosettaMetaData<AdditionalData> {

	@Override
	public List<Validator<? super AdditionalData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdditionalData>create(fpml.confirmation.validation.datarule.AdditionalDataChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdditionalData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdditionalData> validator() {
		return new AdditionalDataValidator();
	}

	@Override
	public Validator<? super AdditionalData> typeFormatValidator() {
		return new AdditionalDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalData, Set<String>> onlyExistsValidator() {
		return new AdditionalDataOnlyExistsValidator();
	}
}
