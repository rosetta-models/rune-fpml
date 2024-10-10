package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReferenceInformation;
import fpml.confirmation.validation.ReferenceInformationTypeFormatValidator;
import fpml.confirmation.validation.ReferenceInformationValidator;
import fpml.confirmation.validation.exists.ReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReferenceInformation.class)
public class ReferenceInformationMeta implements RosettaMetaData<ReferenceInformation> {

	@Override
	public List<Validator<? super ReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReferenceInformation>create(fpml.confirmation.validation.datarule.ReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReferenceInformation> validator() {
		return new ReferenceInformationValidator();
	}

	@Override
	public Validator<? super ReferenceInformation> typeFormatValidator() {
		return new ReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceInformation, Set<String>> onlyExistsValidator() {
		return new ReferenceInformationOnlyExistsValidator();
	}
}
